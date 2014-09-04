package org.primefaces.extensions.showcase.controller.gchart;

import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.component.gchart.model.GChartModel;
import org.primefaces.extensions.component.gchart.model.GChartModelBuilder;
import org.primefaces.extensions.component.gchart.model.GChartModelRow;
import org.primefaces.extensions.component.gchart.model.GChartType;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ManagedBean
@RequestScoped
public class MultipleSeriesGChartController implements Serializable {

    private static final long serialVersionUID = 253762400419864192L;

    private GChartModel chartModel = null;

    public GChartModel getChart(){
        return chartModel;
    }

    @PostConstruct
    public void generateModel() {
        chartModel = new GChartModelBuilder().setChartType(GChartType.COLUMN)
                .addColumns("Year", "Salves","Expenses")
                .addRow("2010",  1000, 400)
                .addRow("2011",  1200, 800)
                .addRow("2012",  2000, 1800)
                .addRow("2013",  1500, 1800)
                .addRow("2014",  1300, 1000)
                .build();
    }
}