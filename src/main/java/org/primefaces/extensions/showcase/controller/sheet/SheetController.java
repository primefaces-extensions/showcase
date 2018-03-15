package org.primefaces.extensions.showcase.controller.sheet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.RandomUtils;
import org.primefaces.extensions.component.sheet.Sheet;
import org.primefaces.extensions.event.SheetUpdate;
import org.primefaces.extensions.showcase.model.sheet.Asset;
import org.primefaces.extensions.showcase.model.sheet.AssetType;
import org.primefaces.extensions.showcase.model.sheet.PlatformArchType;
import org.primefaces.extensions.showcase.model.sheet.PlatformType;

/**
 * {@link Sheet} Controller.
 *
 * @author Melloware mellowaredev@gmail.com
 */
@ManagedBean
@ViewScoped
public class SheetController implements Serializable {

    private static final long serialVersionUID = 20120224L;

    private List<Asset> assets = new ArrayList<>();

    public SheetController() {
        addAssets(40, PlatformType.Linux, PlatformArchType.AMD64, AssetType.SERVER);
        addAssets(50, PlatformType.Windows, PlatformArchType.I386, AssetType.DESKTOP);
        addAssets(60, PlatformType.Mac, PlatformArchType.OTHER, AssetType.LAPTOP);
        addAssets(5, null, null, AssetType.PRINTER);
    }

    public void cellEditEvent(AjaxBehaviorEvent event) {
        Sheet sheet = (Sheet) event.getComponent();
        List<SheetUpdate> updates = sheet.getUpdates();
        // A SheetUpdate exists for each column updated, the same row may
        // appear more than once. For this reason we will track those we already persisted
        HashSet<Asset> processed = new HashSet<Asset>();
        int rowUpdates = 0;
        for (SheetUpdate update : updates) {
            Asset asset = (Asset) update.getRowData();
            if (processed.contains(asset)) {
                continue;
            }
            System.out.println("Asset " + asset.getAssetId() + " updated.");
            rowUpdates++;
        }
        sheet.commitUpdates();
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Update Success", Integer.toString(rowUpdates) + " rows updated"));
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    private void addAssets(int count, PlatformType platform, PlatformArchType arch, AssetType type) {
        for (int i = 0; i < count; i++) {
            Asset asset = new Asset();
            asset.setAssetId(RandomUtils.nextLong());
            asset.setPlatform(platform);
            asset.setPlatformArch(arch);
            asset.setHostName(type.toString().toLowerCase() + i + ".example.lan");
            asset.setAssetType(type);
            asset.setLastUpdated(new Date());
            asset.setValue1(RandomUtils.nextInt(1, 1000));
            getAssets().add(asset);
        }
    }

}
