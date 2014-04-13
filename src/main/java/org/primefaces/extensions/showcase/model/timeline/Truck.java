package org.primefaces.extensions.showcase.model.timeline;

import java.io.Serializable;

public class Truck implements Serializable {

    private String imagePath;
    private String text;

    public Truck(String imagePath, String text) {
        this.imagePath = imagePath;
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getText() {
        return text;
    }
}
