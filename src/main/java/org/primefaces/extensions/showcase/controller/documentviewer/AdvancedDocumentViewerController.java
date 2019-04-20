package org.primefaces.extensions.showcase.controller.documentviewer;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AdvancedDocumentViewerController implements Serializable {

	private static final long serialVersionUID = 1L;

    private int page = 2;
    private String locale = "en";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
