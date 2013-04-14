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

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.extensions.showcase.model.timeline.Order;

/**
 * GroupingTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
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
		MessageFormat messageFormat =
		    new MessageFormat("<img src='" + FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
		                      + "/resources/images/timeline/truck.png' style='vertical-align:middle'>"
		                      + "<span style='font-weight:bold;'>Truck {0}</span>");

		// initalize markup for group
		String[] TRUCKS = new String[6];
		TRUCKS[0] = messageFormat.format(new String[] {"10"});
		TRUCKS[1] = messageFormat.format(new String[] {"11"});
		TRUCKS[2] = messageFormat.format(new String[] {"12"});
		TRUCKS[3] = messageFormat.format(new String[] {"13"});
		TRUCKS[4] = messageFormat.format(new String[] {"14"});
		TRUCKS[5] = messageFormat.format(new String[] {"15"});

		// create timeline model
		model = new TimelineModel();

		// Server-side dates should be in UTC. They will be converted to a local dates in UI according to provided TimeZone.
		// Submitted local dates in UI are converted back to UTC, so that server receives all dates in UTC again.
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		int orderNumber = 1;

		for (String truckText : TRUCKS) {
			cal.set(2012, Calendar.DECEMBER, 14, 8, 0, 0);
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
				model.add(new TimelineEvent(order, startDate, endDate, true, truckText));

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
		requestContext.execute("overlapEventsWdgt.show()");
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
