/*
 * Copyright 2012 PrimeFaces Extensions.
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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline_old.DefaultTimeLine;
import org.primefaces.extensions.model.timeline_old.DefaultTimelineEvent;
import org.primefaces.extensions.model.timeline_old.Timeline;

/**
 * DOCUMENT_ME
 *
 *
 * @author  Nilesh Mali / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class BasicTimelineController implements Serializable {

	private Timeline timeline;
	private String eventStyle = "dot";
	private String axisPosition = "bottom";
	private boolean showNavigation = false;

	public BasicTimelineController() {
		Calendar cal = Calendar.getInstance();
		timeline = new DefaultTimeLine("prh", "Primefaces Release History");
		cal.set(2011, 4, 10);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.1", cal.getTime()));
		cal.set(2012, 0, 23);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.2.0", cal.getTime()));
		cal.set(2012, 3, 02);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces Extensions 0.3.0", cal.getTime()));
		cal.set(2012, 3, 16);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.4.0", cal.getTime()));
		cal.set(2012, 5, 10);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.5.0", cal.getTime()));
		cal.set(2012, 5, 19);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.5.1", cal.getTime()));
		cal.set(2012, 8, 26);
		timeline.addEvent(new DefaultTimelineEvent("Primefaces-Extensions 0.6.0", cal.getTime()));
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public String getEventStyle() {
		return eventStyle;
	}

	public void setEventStyle(String eventStyle) {
		this.eventStyle = eventStyle;
	}

	public String getAxisPosition() {
		return axisPosition;
	}

	public void setAxisPosition(String axisPosition) {
		this.axisPosition = axisPosition;
	}

	public boolean isShowNavigation() {
		return showNavigation;
	}

	public void setShowNavigation(boolean showNavigation) {
		this.showNavigation = showNavigation;
	}
}
