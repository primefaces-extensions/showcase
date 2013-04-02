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

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.extensions.showcase.model.timeline.Task;

/**
 * LinkedTimelinesController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class LinkedTimelinesController implements Serializable {

	private TimelineModel modelFirst; // model of the first timeline
	private TimelineModel modelSecond; // model of the second timeline

	@PostConstruct
	protected void initialize() {
		createFirstTimeline();
		createSecondTimeline();
	}

	private void createFirstTimeline() {
		modelFirst = new TimelineModel();

		Calendar cal = Calendar.getInstance();
		cal.set(2012, Calendar.AUGUST, 22, 17, 30, 0);
		modelFirst.add(new TimelineEvent(new Task("Mail from boss", "timeline/mail.png", false), cal.getTime()));

		cal.set(2012, Calendar.AUGUST, 23, 23, 0, 0);
		modelFirst.add(new TimelineEvent(new Task("Call back my boss", "timeline/callback.png", false), cal.getTime()));

		cal.set(2012, Calendar.AUGUST, 24, 21, 45, 0);
		modelFirst.add(new TimelineEvent(new Task("Travel to Spain", "timeline/location.png", false), cal.getTime()));

		cal.set(2012, Calendar.AUGUST, 26, 0, 0, 0);
		Date startWork = cal.getTime();
		cal.set(2012, Calendar.SEPTEMBER, 2, 0, 0, 0);
		Date endWork = cal.getTime();
		modelFirst.add(new TimelineEvent(new Task("Do homework", "timeline/homework.png", true), startWork, endWork));

		cal.set(2012, Calendar.AUGUST, 28, 0, 0, 0);
		modelFirst.add(new TimelineEvent(new Task("Create memo", "timeline/memo.png", false), cal.getTime()));

		cal.set(2012, Calendar.AUGUST, 31, 0, 0, 0);
		Date startReport = cal.getTime();
		cal.set(2012, Calendar.SEPTEMBER, 3, 0, 0, 0);
		Date endReport = cal.getTime();
		modelFirst.add(new TimelineEvent(new Task("Create report", "timeline/report.png", true), startReport, endReport));
	}

	private void createSecondTimeline() {
		modelSecond = new TimelineModel();

		Calendar cal = Calendar.getInstance();

		cal.set(2012, Calendar.AUGUST, 23, 0, 0, 0);
		Date startProject = cal.getTime();
		cal.set(2012, Calendar.AUGUST, 30, 0, 0, 0);
		Date endProject = cal.getTime();
		modelSecond.add(new TimelineEvent("Project A", startProject, endProject));

		cal.set(2012, Calendar.AUGUST, 27, 0, 0, 0);
		startProject = cal.getTime();
		cal.set(2012, Calendar.AUGUST, 31, 0, 0, 0);
		endProject = cal.getTime();
		modelSecond.add(new TimelineEvent("Project B", startProject, endProject));
	}

	public TimelineModel getModelFirst() {
		return modelFirst;
	}

	public TimelineModel getModelSecond() {
		return modelSecond;
	}
}
