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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
		// get changed event
		event = e.getTimelineEvent();

		// get overlapped events of the same group as the changed event
		TreeSet<TimelineEvent> overlappedEvents = model.getOverlappedEvents(event);

		System.out.println(overlappedEvents != null ? Arrays.toString(overlappedEvents.toArray()) : "null");
	}
}
