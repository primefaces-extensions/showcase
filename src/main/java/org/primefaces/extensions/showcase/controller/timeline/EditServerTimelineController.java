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
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineAddEvent;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.extensions.showcase.model.timeline.Booking;
import org.primefaces.extensions.showcase.model.timeline.RoomCategory;

/**
 * EditServerTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class EditServerTimelineController implements Serializable {

	private TimelineModel model;
	private TimelineEvent event; // current event to be changed, edited, deleted or added
	private long zoomMax;
	private Date start;
	private Date end;
	private TimeZone timeZone = TimeZone.getTimeZone("Europe/Madrid");

	@PostConstruct
	protected void initialize() {
		// initial zooming is ca. one month to avoid hiding of event details (due to wide time range of events)
		zoomMax = 1000L * 60 * 60 * 24 * 30;

		// set initial start / end dates for the axis of the timeline (just for testing)
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.set(2013, Calendar.FEBRUARY, 9, 0, 0, 0);
		start = cal.getTime();
		cal.set(2013, Calendar.MARCH, 10, 0, 0, 0);
		end = cal.getTime();

		// create timeline model
		model = new TimelineModel();

		// Server-side dates should be in UTC. They will be converted to a local dates in UI according to provided TimeZone.
		// Submitted local dates in UI are converted back to UTC, so that server receives all dates in UTC again.
		cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.set(2013, Calendar.JANUARY, 2, 0, 0, 0);
		model.add(new TimelineEvent(new Booking(211, RoomCategory.DELUXE, "(0034) 987-111", "One day booking"), cal.getTime()));

		cal.set(2013, Calendar.JANUARY, 26, 0, 0, 0);
		Date begin = cal.getTime();
		cal.set(2013, Calendar.JANUARY, 28, 23, 59, 59);
		Date end = cal.getTime();
		model.add(new TimelineEvent(new Booking(202, RoomCategory.EXECUTIVE_SUITE, "(0034) 987-333", "Three day booking"), begin,
		                            end));

		cal.set(2013, Calendar.FEBRUARY, 10, 0, 0, 0);
		begin = cal.getTime();
		cal.set(2013, Calendar.FEBRUARY, 15, 23, 59, 59);
		end = cal.getTime();
		model.add(new TimelineEvent(new Booking(150, RoomCategory.STANDARD, "(0034) 987-222", "Six day booking"), begin, end));

		cal.set(2013, Calendar.FEBRUARY, 23, 0, 0, 0);
		begin = cal.getTime();
		cal.set(2013, Calendar.FEBRUARY, 27, 23, 59, 59);
		end = cal.getTime();
		model.add(new TimelineEvent(new Booking(178, RoomCategory.STANDARD, "(0034) 987-555", "Five day booking"), begin, end));

		cal = Calendar.getInstance();
		cal.set(2013, Calendar.MARCH, 6, 0, 0, 0);
		model.add(new TimelineEvent(new Booking(101, RoomCategory.SUPERIOR, "(0034) 987-999", "One day booking"), cal.getTime()));

		cal.set(2013, Calendar.MARCH, 19, 0, 0, 0);
		begin = cal.getTime();
		cal.set(2013, Calendar.MARCH, 22, 23, 59, 59);
		end = cal.getTime();
		model.add(new TimelineEvent(new Booking(80, RoomCategory.JUNIOR, "(0034) 987-444", "Four day booking"), begin, end));

		cal.set(2013, Calendar.APRIL, 3, 0, 0, 0);
		begin = cal.getTime();
		cal.set(2013, Calendar.APRIL, 4, 23, 59, 59);
		end = cal.getTime();
		model.add(new TimelineEvent(new Booking(96, RoomCategory.DELUXE, "(0034) 987-777", "Two day booking"), begin, end));

		cal.set(2013, Calendar.APRIL, 22, 0, 0, 0);
		begin = cal.getTime();
		cal.set(2013, Calendar.MAY, 1, 23, 59, 59);
		end = cal.getTime();
		model.add(new TimelineEvent(new Booking(80, RoomCategory.JUNIOR, "(0034) 987-444", "Ten day booking"), begin, end));
	}

	public void onChange(TimelineModificationEvent e) {
		// get clone of the TimelineEvent to be changed with new start / end dates
		event = e.getTimelineEvent();

		// update booking in DB...

		// if everything was ok, no UI update is required. Only the model should be updated
		model.update(event);

		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "The booking dates " + getRoom() + " have been updated", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// otherwise (if DB operation failed) a rollback can be done with the same response as follows:
		// TimelineEvent oldEvent = model.getEvent(model.getIndex(event));
		// TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":mainForm:timeline");
		// model.update(oldEvent, timelineUpdater);
	}

	public void onEdit(TimelineModificationEvent e) {
		// get clone of the TimelineEvent to be edited
		event = e.getTimelineEvent();
	}

	public void onAdd(TimelineAddEvent e) {
		// get TimelineEvent to be added
		event = new TimelineEvent(new Booking(), e.getStartDate(), e.getEndDate(), true, e.getGroup());

		// add the new event to the model in case if user will close or cancel the "Add dialog"
		// without to update details of the new event. Note: the event is already added in UI.
		model.add(event);
	}

	public void onDelete(TimelineModificationEvent e) {
		// get clone of the TimelineEvent to be deleted
		event = e.getTimelineEvent();
	}

	public void delete() {
		// delete booking in DB...

		// if everything was ok, delete the TimelineEvent in the model and update UI with the same response.
		// otherwise no server-side delete is necessary (see timelineWdgt.cancelDelete() in the p:ajax onstart).
		// we assume, delete in DB was successful
		TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":mainForm:timeline");
		model.delete(event, timelineUpdater);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "The booking " + getRoom() + " has been deleted", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void saveDetails() {
		// save the updated booking in DB...

		// if everything was ok, update the TimelineEvent in the model and update UI with the same response.
		// otherwise no server-side update is necessary because UI is already up-to-date.
		// we assume, save in DB was successful
		TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":mainForm:timeline");
		model.update(event, timelineUpdater);

		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "The booking details " + getRoom() + " have been saved", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public TimelineModel getModel() {
		return model;
	}

	public TimelineEvent getEvent() {
		return event;
	}

	public void setEvent(TimelineEvent event) {
		this.event = event;
	}

	public long getZoomMax() {
		return zoomMax;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public String getDeleteMessage() {
		Integer room = ((Booking) event.getData()).getRoomNumber();
		if (room == null) {
			return "Do you really want to delete the new booking?";
		}

		return "Do you really want to delete the booking for the room " + room + "?";
	}

	public String getRoom() {
		Integer room = ((Booking) event.getData()).getRoomNumber();
		if (room == null) {
			return "(new booking)";
		} else {
			return "(room " + room + ")";
		}
	}
}
