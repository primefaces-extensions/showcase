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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 * CustomTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class CustomTimelineController implements Serializable {

	private TimelineModel model;
	private String locale; // current locale as String, java.util.Locale is possible too.
	private Date start;
	private Date end;

	@PostConstruct
	protected void initialize() {
		// set initial start / end dates for the axis of the timeline
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		Date now = new Date();

		cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);
		start = cal.getTime();

		cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);
		end = cal.getTime();

		// groups
		String[] NAMES = new String[] {"Thomas", "Oleg", "Nilesh", "Mauricio", "Pavol", "Sudheer"};

		// create timeline model
		model = new TimelineModel();

		for (String name : NAMES) {
			now = new Date();
			Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);

			for (int i = 0; i < 5; i++) {
				Date start = new Date(end.getTime() + Math.round(Math.random() * 5) * 60 * 60 * 1000);
				end = new Date(start.getTime() + Math.round(4 + Math.random() * 5) * 60 * 60 * 1000);

				long r = Math.round(Math.random() * 2);
				String availability = (r == 0 ? "Unavailable" : (r == 1 ? "Available" : "Maybe"));

				// create an event with content, start / end dates, editable flag, group name and custom style class
				TimelineEvent event = new TimelineEvent(availability, start, end, true, name, availability.toLowerCase());
				model.add(event);
			}
		}
	}

	public TimelineModel getModel() {
		return model;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
}
