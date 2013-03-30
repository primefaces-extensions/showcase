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

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 * BasicTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class BasicTimelineController implements Serializable {

	private TimelineModel model;

	// default settings
	private boolean axisOnTop;
	private boolean editable;
	private boolean selectable;
	private boolean zoomable;
	private boolean moveable;
	private String eventStyle = "box";
	private boolean showCurrentTime = true;
	private boolean showButtonNew = false;
	private boolean showNavigation = false;

	@PostConstruct
	protected void initialize() {
	}

	public BasicTimelineController() {
		model = new TimelineModel();

		Calendar cal = Calendar.getInstance();
		cal.set(2011, Calendar.MAY, 10);
		model.add(new TimelineEvent("Primefaces-Extensions 0.1", cal.getTime()));

		cal.set(2012, Calendar.JANUARY, 23);
		model.add(new TimelineEvent("Primefaces-Extensions 0.2.0", cal.getTime()));

		cal.set(2012, Calendar.APRIL, 2);
		model.add(new TimelineEvent("Primefaces-Extensions 0.3.0", cal.getTime()));

		cal.set(2012, Calendar.APRIL, 16);
		model.add(new TimelineEvent("Primefaces-Extensions 0.4.0", cal.getTime()));

		cal.set(2012, Calendar.JUNE, 10);
		model.add(new TimelineEvent("Primefaces-Extensions 0.5.0", cal.getTime()));

		cal.set(2012, Calendar.JUNE, 19);
		model.add(new TimelineEvent("Primefaces-Extensions 0.5.1", cal.getTime()));

		cal.set(2012, Calendar.SEPTEMBER, 26);
		model.add(new TimelineEvent("Primefaces-Extensions 0.6.0", cal.getTime()));

		cal.set(2012, Calendar.OCTOBER, 13);
		model.add(new TimelineEvent("Primefaces-Extensions 0.6.1", cal.getTime()));

		cal.set(2012, Calendar.DECEMBER, 16);
		model.add(new TimelineEvent("Primefaces-Extensions 0.6.2", cal.getTime()));

		cal.set(2013, Calendar.FEBRUARY, 3);
		model.add(new TimelineEvent("Primefaces-Extensions 0.6.3", cal.getTime()));
	}

	public TimelineModel getModel() {
		return model;
	}

	public void setModel(TimelineModel model) {
		this.model = model;
	}

	public boolean isAxisOnTop() {
		return axisOnTop;
	}

	public void setAxisOnTop(boolean axisOnTop) {
		this.axisOnTop = axisOnTop;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isZoomable() {
		return zoomable;
	}

	public void setZoomable(boolean zoomable) {
		this.zoomable = zoomable;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}

	public String getEventStyle() {
		return eventStyle;
	}

	public void setEventStyle(String eventStyle) {
		this.eventStyle = eventStyle;
	}

	public boolean isShowCurrentTime() {
		return showCurrentTime;
	}

	public void setShowCurrentTime(boolean showCurrentTime) {
		this.showCurrentTime = showCurrentTime;
	}

	public boolean isShowButtonNew() {
		return showButtonNew;
	}

	public void setShowButtonNew(boolean showButtonNew) {
		this.showButtonNew = showButtonNew;
	}

	public boolean isShowNavigation() {
		return showNavigation;
	}

	public void setShowNavigation(boolean showNavigation) {
		this.showNavigation = showNavigation;
	}
}
