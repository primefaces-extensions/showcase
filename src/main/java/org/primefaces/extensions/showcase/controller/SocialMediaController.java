package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.extensions.component.social.Social;

/**
 * {@link Social} Controller.
 *
 * @author Melloware mellowaredev@gmail.com
 */
@ManagedBean
@ViewScoped
public class SocialMediaController implements Serializable {

    private static final long serialVersionUID = 20120224L;

    private int fontSize = 12;
    private String theme = "classic";
    private String showCount = "true";
    private boolean showLabel = true;

    public List<SelectItem> getThemes() {
        final List<SelectItem> results = new ArrayList<SelectItem>();
        results.add(new SelectItem("classic", "classic"));
        results.add(new SelectItem("flat", "flat"));
        results.add(new SelectItem("minima", "minima"));
        results.add(new SelectItem("plain", "plain"));
        return results;
    }

    public List<SelectItem> getCountOptions() {
        final List<SelectItem> results = new ArrayList<SelectItem>();
        results.add(new SelectItem("true", "display"));
        results.add(new SelectItem("false", "hide"));
        results.add(new SelectItem("inside", "inside"));
        return results;
    }

    public String getShowCount() {
        return showCount;
    }

    public void setShowCount(String showCount) {
        this.showCount = showCount;
    }

    public boolean isShowLabel() {
        return showLabel;
    }

    public void setShowLabel(boolean showLabel) {
        this.showLabel = showLabel;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
