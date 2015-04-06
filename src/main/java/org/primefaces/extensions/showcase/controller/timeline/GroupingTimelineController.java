/*
 * Copyright 2012-2013 PrimeFaces Extensions.
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
 *
 * $Id$
 */

package org.primefaces.extensions.showcase.controller.timeline;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineGroup;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.extensions.showcase.model.timeline.Order;
import org.primefaces.extensions.showcase.model.timeline.Truck;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

/**
 * GroupingTimelineController
 *
 * @author Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class GroupingTimelineController implements Serializable {

    private TimelineModel model;
    private TimelineEvent event; // current changed event
    private List<TimelineEvent> overlappedOrders; // all overlapped orders (events) to the changed order (event)
    private List<TimelineEvent> ordersToMerge; // selected orders (events) in the dialog which should be merged

    @PostConstruct
    protected void initialize() {
        // create timeline model
        model = new TimelineModel();

        // create groups
        TimelineGroup group1 = new TimelineGroup("id1", new Truck("/resources/images/timeline/truck.png", "10"));
        TimelineGroup group2 = new TimelineGroup("id2", new Truck("/resources/images/timeline/truck.png", "11"));
        TimelineGroup group3 = new TimelineGroup("id3", new Truck("/resources/images/timeline/truck.png", "12"));
        TimelineGroup group4 = new TimelineGroup("id4", new Truck("/resources/images/timeline/truck.png", "13"));
        TimelineGroup group5 = new TimelineGroup("id5", new Truck("/resources/images/timeline/truck.png", "14"));
        TimelineGroup group6 = new TimelineGroup("id6", new Truck("/resources/images/timeline/truck.png", "15"));

        // add groups to the model
        model.addGroup(group1);
        model.addGroup(group2);
        model.addGroup(group3);
        model.addGroup(group4);
        model.addGroup(group5);
        model.addGroup(group6);

        // Server-side dates should be in UTC. They will be converted to a local dates in UI according to provided TimeZone.
        // Submitted local dates in UI are converted back to UTC, so that server receives all dates in UTC again.
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        int orderNumber = 1;

        // iterate over groups
        for (int j = 1; j <= 6; j++) {
            cal.set(2015, Calendar.DECEMBER, 14, 8, 0, 0);
            // iterate over events in the same group
            for (int i = 0; i < 6; i++) {
                cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 3 * (Math.random() < 0.2 ? 1 : 0));
                Date startDate = cal.getTime();

                cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 2 + (int) Math.floor(Math.random() * 4));
                Date endDate = cal.getTime();

                String imagePath = null;
                if (Math.random() < 0.25) {
                    imagePath = "/resources/images/timeline/box.png";
                }

                Order order = new Order(orderNumber, imagePath);
                model.add(new TimelineEvent(order, startDate, endDate, true, "id" + j));
                
                orderNumber++;
            }
        }
    }

    public TimelineModel getModel() {
        return model;
    }

    public void onChange(TimelineModificationEvent e) {
        // get changed event and update the model
        event = e.getTimelineEvent();
        model.update(event);

        // get overlapped events of the same group as for the changed event
        TreeSet<TimelineEvent> overlappedEvents = model.getOverlappedEvents(event);

        if (overlappedEvents == null) {
            // nothing to merge
            return;
        }

        // list of orders which can be merged in the dialog
        overlappedOrders = new ArrayList<TimelineEvent>(overlappedEvents);

        // no pre-selection
        ordersToMerge = null;

        // update the dialog's content and show the dialog
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.update("overlappedOrdersInner");
        requestContext.execute("PF('overlapEventsWdgt').show()");
    }

    public void onDelete(TimelineModificationEvent e) {
        // keep the model up-to-date
        model.delete(e.getTimelineEvent());
    }

    public void merge() {
        // merge orders and update UI if the user selected some orders to be merged
        if (ordersToMerge != null && !ordersToMerge.isEmpty()) {
            model.merge(event, ordersToMerge, TimelineUpdater.getCurrentInstance(":mainForm:timeline"));
        } else {
            FacesMessage msg =
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Nothing to merge, please choose orders to be merged", null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        overlappedOrders = null;
        ordersToMerge = null;
    }

    public int getSelectedOrder() {
        if (event == null) {
            return 0;
        }

        return ((Order) event.getData()).getNumber();
    }

    public List<TimelineEvent> getOverlappedOrders() {
        return overlappedOrders;
    }

    public List<TimelineEvent> getOrdersToMerge() {
        return ordersToMerge;
    }

    public void setOrdersToMerge(List<TimelineEvent> ordersToMerge) {
        this.ordersToMerge = ordersToMerge;
    }
}
