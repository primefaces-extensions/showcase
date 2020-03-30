package org.primefaces.extensions.showcase.controller.fuzzysearch;

import org.primefaces.extensions.showcase.model.fuzzysearch.FuzzySearchItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

@Named
@ViewScoped
public class FuzzySearchController implements Serializable {

    private static final long serialVersionUID = 20120224L;

    private List<FuzzySearchItem> items;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
        items.add(new FuzzySearchItem("fileName1", "name1"));
        items.add(new FuzzySearchItem("fileName2", "name2"));
        items.add(new FuzzySearchItem("fileName3", "name3"));
        items.add(new FuzzySearchItem("fileName4", "name4"));
        items.add(new FuzzySearchItem("fileName5", "name5"));
    }

    public void onSelect(SelectEvent<FuzzySearchItem> event) {
        FuzzySearchItem item = event.getObject();
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Select fired",
                "Item is: " + item.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<FuzzySearchItem> getItems() {
        return items;
    }

}
