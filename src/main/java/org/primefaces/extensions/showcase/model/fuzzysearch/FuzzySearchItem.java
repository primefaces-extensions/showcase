package org.primefaces.extensions.showcase.model.fuzzysearch;

import java.io.Serializable;
import org.primefaces.extensions.component.fuzzysearch.FuzzySearchKey;

public class FuzzySearchItem implements Serializable {

    private String fileName;

    @FuzzySearchKey
    private String name;

    public FuzzySearchItem() {
    }

    public FuzzySearchItem(String fileName, String name) {
        this.fileName = fileName;
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
