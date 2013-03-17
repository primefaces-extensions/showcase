/*
 * Copyright 2011-2013 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.extensions.showcase.controller.exporter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;
import org.primefaces.extensions.showcase.model.Vehicle;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * VehicleTableController
 *
 * @author Sudheer Jonna / last modified by $Author$
 * @version $Revision: 1.0 $
 * @since 0.7.0
 */
@ManagedBean
@ViewScoped
public class VehicleTableController implements Serializable {

    private final static String[] manufacturers;
    private final static String[] colors;

    private List<Vehicle> vehicles;
    private List<String> customersDetails = new ArrayList<String>();

    private final static String[] customersDetails1;
    private final static String[] customersDetails2;
    private List<String> customersDetailsList1 = new ArrayList<String>();
    private List<String> customersDetailsList2 = new ArrayList<String>();


    static {

        customersDetails1 = new String[6];
        customersDetails1[0] = "Name: Thomas Country: Germany";
        customersDetails1[1] = "Name: Oleg Country: Germany";
        customersDetails1[2] = "Name: Nilesh Country: India";
        customersDetails1[3] = "Name: fenoqlio Country: Uruguay";
        customersDetails1[4] = "Name: Oval Country: Germany";
        customersDetails1[5] = "Name: Sudheer Country: India";

        customersDetails2 = new String[7];
        customersDetails2[0] = "Name: Narayana Country: India";
        customersDetails2[1] = "Name: Anu Country: India";
        customersDetails2[2] = "Name: Uma Country: India";
        customersDetails2[3] = "Name: Surendra Country: India";
        customersDetails2[4] = "Name: Vineet Country: Canada";
        customersDetails2[5] = "Name: Karthik Country: Canada";
        customersDetails2[6] = "Name: Sudheer Country: India";

        manufacturers = new String[7];
        manufacturers[0] = "Mercedes";
        manufacturers[1] = "BMW";
        manufacturers[2] = "Volvo";
        manufacturers[3] = "Audi";
        manufacturers[4] = "Volkswagen";
        manufacturers[5] = "Ferrari";
        manufacturers[6] = "Ford";

        colors = new String[7];
        colors[0] = "Red";
        colors[1] = "White";
        colors[2] = "Yellow";
        colors[3] = "Green";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Black";

    }


    public VehicleTableController() {
        vehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 6; i++) {
            customersDetailsList1.add(customersDetails1[i]);
        }
        for (int i = 0; i < 7; i++) {
            customersDetailsList2.add(customersDetails2[i]);
        }
        populateRandomVehicles(vehicles, 6);
    }

    private void populateRandomVehicles(List<Vehicle> vehicles, int size) {
        for (int i = 0; i < size; i++) {
            customersDetails = new ArrayList<String>();
            if ((i + 1) % 2 == 0) {
                customersDetails = customersDetailsList2;
            } else {
                customersDetails = customersDetailsList1;
            }
            vehicles.add(new Vehicle(i + 1, getRandomManufacturer(), getRandomColor(), getRandomSpeed(), getRandomPrice(), getRandomYear(), customersDetails));
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    private String getRandomManufacturer() {
        return manufacturers[(int) (Math.random() * 6)];
    }

    public List<String> getCustomersDetails() {
        return customersDetails;
    }

    private int getRandomSpeed() {
        return (int) (Math.random() * 10 + 150);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 6)];
    }

    private int getRandomPrice() {
        return (int) (Math.random() * 10 + 10000);
    }


    public void onRowToggle(ToggleEvent event) {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected Vehicle", "Manufacturer:" + ((Vehicle) event.getData()).getManufacturer());

        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}