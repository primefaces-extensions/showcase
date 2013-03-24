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
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline_old.DefaultTimeLine;
import org.primefaces.extensions.model.timeline_old.DefaultTimelineEvent;
import org.primefaces.extensions.model.timeline_old.Timeline;
import org.primefaces.extensions.model.timeline_old.TimelineEvent;

/**
 * DOCUMENT_ME
 *
 *
 * @author  Nilesh Mali / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class CustomStyleController implements Serializable {

	private Timeline timeline;

	public CustomStyleController() {
		timeline = new DefaultTimeLine("pt", "Custom Style");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -5);
		cal.set(Calendar.HOUR_OF_DAY, 1);

		TimelineEvent timelineEvent;
		Date start;
		Date end;
		for (int event = 1; event < 10; ++event) {
			cal.add(Calendar.HOUR_OF_DAY, 1 + 2 * ((Math.random() < 0.2) ? 1 : 0));
			start = cal.getTime();
			cal.add(Calendar.HOUR_OF_DAY, 2 + (int) (Math.floor(Math.random() * 4)));
			end = cal.getTime();
			timelineEvent = new DefaultTimelineEvent("Event " + event, start, end);

			timelineEvent.setStyleClass(Math.random() > 0.25 ? "green" : "red");

			timeline.addEvent(timelineEvent);
		}
	}

	public Timeline getTimeline() {
		return timeline;
	}
}
