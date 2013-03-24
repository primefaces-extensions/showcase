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
public class PerformanceController implements Serializable {

	private Timeline timeline;

	public PerformanceController() {
		timeline = new DefaultTimeLine("pt", "Timeline Performance");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -5);
		cal.set(Calendar.HOUR_OF_DAY, 1);
		for (int event = 1; event < 200; ++event) {
			cal.add(Calendar.HOUR_OF_DAY, 1 + 4 * ((Math.random() < 0.2) ? 1 : 0));
			timeline.addEvent(new DefaultTimelineEvent("Event " + event, cal.getTime()));
		}
	}

	public Timeline getTimeline() {
		return timeline;
	}
}
