package org.primefaces.extensions.showcase.controller.sheet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.primefaces.extensions.showcase.model.sheet.AssetType;
import org.primefaces.extensions.showcase.model.sheet.PlatformArchType;
import org.primefaces.extensions.showcase.model.sheet.PlatformType;

@ManagedBean
@ApplicationScoped
public class SheetOptionProducer {

	List<SelectItem> assetTypes;
	List<SelectItem> platformTypes;
	List<SelectItem> archTypes;

	@PostConstruct
	private void init() {
		assetTypes = createEnumList(AssetType.values());
		platformTypes = createEnumList(PlatformType.values());
		archTypes = createEnumList(PlatformArchType.values());
	}

	private <T extends Enum<?>> List<SelectItem> createEnumList(T[] values) {
		List<SelectItem> result = new ArrayList<SelectItem>();
		result.add(new SelectItem("", "All"));
		for (T value : values)
			result.add(new SelectItem(value, value.name()));
		return result;
	}

	public List<SelectItem> getAssetTypes() {
		return assetTypes;
	}

	public List<SelectItem> getPlatformTypes() {
		return platformTypes;
	}

	public List<SelectItem> getArchTypes() {
		return archTypes;
	}

}
