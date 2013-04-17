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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 * EditClientTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class EditClientTimelineController implements Serializable {

	private TimelineModel model;

	private TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");

	@PostConstruct
	protected void initialize() {
		model = new TimelineModel();

		String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();

		// Server-side dates should be in UTC. They will be converted to a local dates in UI according to provided TimeZone.
		// Submitted local dates in UI are converted back to UTC, so that server receives all dates in UTC again.
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.set(2012, Calendar.AUGUST, 22, 17, 30, 0);
		model.add(new TimelineEvent("<div>Mail from boss</div><img src='" + contextPath
		                            + "/resources/images/timeline/mail.png' style='width:32px;height:26px;'>", cal.getTime()));

		cal.set(2012, Calendar.AUGUST, 23, 23, 0, 0);
		model.add(new TimelineEvent("<div>Call back my boss</div><img src='" + contextPath
		                            + "/resources/images/timeline/callback.png' style='width:30px;height:30px;'>",
		                            cal.getTime()));

		// read-only event
		cal.set(2012, Calendar.AUGUST, 24, 21, 45, 0);
		model.add(new TimelineEvent("<div>Travel to Spain</div><img src='" + contextPath
		                            + "/resources/images/timeline/location.png' style='width:20px;height:32px;'>", cal.getTime(),
		                            false, null, "readonly"));

		cal.set(2012, Calendar.AUGUST, 26, 0, 0, 0);
		Date startWork = cal.getTime();
		cal.set(2012, Calendar.SEPTEMBER, 2, 0, 0, 0);
		Date endWork = cal.getTime();
		model.add(
		    new TimelineEvent(
		        "<img src='" + contextPath
		        + "/resources/images/timeline/homework.png' style='width:31px;height:29px;'><span style='padding:8px'>Homework</span>",
		        startWork, endWork));

		cal.set(2012, Calendar.AUGUST, 28, 0, 0, 0);
		model.add(new TimelineEvent("<div>Memo</div><img src='" + contextPath
		                            + "/resources/images/timeline/memo.png' style='width:32px;height:32px;'>", cal.getTime()));

		// read-only event
		cal.set(2012, Calendar.AUGUST, 31, 0, 0, 0);
		Date startReport = cal.getTime();
		cal.set(2012, Calendar.SEPTEMBER, 3, 0, 0, 0);
		Date endReport = cal.getTime();
		model.add(
		    new TimelineEvent(
		        "<img src='" + contextPath
		        + "/resources/images/timeline/report.png' style='width:32px;height:31px;'><span style='padding:8px'>Report</span>",
		        startReport, endReport, false, null, "readonly"));
	}

	public TimelineModel getModel() {
		return model;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void updateData(List<TimelineEvent> events) {
		// update model
		model.setEvents(events);

		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Timeline model has been updated",
		                     events != null ? events.size() + " events available" : "0 events available");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
