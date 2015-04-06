/*
 * Copyright 2011-2015 PrimeFaces Extensions
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineDragDropEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.extensions.showcase.model.timeline.Event;
import org.primefaces.extensions.showcase.util.TimeZoneUtil;

/**
 * DndTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class DndTimelineController implements Serializable {

	private TimelineModel model;
	private Date start;
	private Date end;

	// time zone the timeline to be displayed in
	private String localTZ = "Europe/Berlin";

	// your browser's time zone (defaults to the server's time zone)
	private String browserTZ = TimeZone.getDefault().getID();

	// all available time zones
	private List<SelectItem> timeZones;

	// events for drag and drop
	private List<Event> events = new ArrayList<Event>();

	@PostConstruct
	protected void initialize() {
		// set initial start / end dates for the axis of the timeline
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		Date now = new Date();

		cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);
		start = cal.getTime();

		cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);
		end = cal.getTime();

		// create timeline model
		model = new TimelineModel();

		// create available events for drag-&-drop
		for (int i = 1; i <= 13; i++) {
			events.add(new Event("Event " + i));
		}

		// get all unique time zones (code of the TimeZoneUtil is not relevant here)
		timeZones = new ArrayList<SelectItem>();
		for (TimeZone timeZone : TimeZoneUtil.getTimeZones()) {
			timeZones.add(new SelectItem(timeZone.getID(), TimeZoneUtil.getName(timeZone)));
		}
	}

	public void onDrop(TimelineDragDropEvent e) {
		// get dragged model object (event class) if draggable item is within a data iteration component,
		// update event's start and end dates.
		Event dndEvent = (Event) e.getData();
		dndEvent.setStart(e.getStartDate());
		dndEvent.setEnd(e.getEndDate());

		// create a timeline event (not editable)
		TimelineEvent event = new TimelineEvent(dndEvent, e.getStartDate(), e.getEndDate(), false, e.getGroup());

		// add a new event
		TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":mainForm:timeline");
		model.add(event, timelineUpdater);

		// remove from the list of all events
		events.remove(dndEvent);

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "The " + dndEvent.getName() + " was added", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onSwitchTimeZone(AjaxBehaviorEvent e) {
		model.clear();
	}

	public TimelineModel getModel() {
		return model;
	}

	public String getLocalTZ() {
		return localTZ;
	}

	public void setLocalTZ(String localTZ) {
		this.localTZ = localTZ;
	}

	public String getBrowserTZ() {
		return browserTZ;
	}

	public void setBrowserTZ(String browserTZ) {
		this.browserTZ = browserTZ;
	}

	public List<SelectItem> getTimeZones() {
		return timeZones;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
}
