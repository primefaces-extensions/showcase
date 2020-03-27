package org.primefaces.extensions.showcase.controller.fuzzysearch;

import org.primefaces.extensions.showcase.model.fuzzysearch.FuzzySearchItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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

    public List<FuzzySearchItem> getItems() {
        return items;
    }

}
