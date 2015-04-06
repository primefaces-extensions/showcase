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
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.RandomStringUtils;

import org.primefaces.extensions.component.timeline.TimelineUpdater;
import org.primefaces.extensions.event.timeline.TimelineLazyLoadEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 * LazyTimelineController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class LazyTimelineController implements Serializable {

	private TimelineModel model;

	private float preloadFactor = 0;
	private long zoomMax;

	@PostConstruct
	protected void initialize() {
		// create empty model
		model = new TimelineModel();

		// about five months in milliseconds for zoomMax
		// this can help to avoid a long loading of events when zooming out to wide time ranges
		zoomMax = 1000L * 60 * 60 * 24 * 31 * 5;
	}

	public TimelineModel getModel() {
		return model;
	}

	public void onLazyLoad(TimelineLazyLoadEvent e) {
		try {
			// simulate time-consuming loading before adding new events
			Thread.sleep((long) (1000 * Math.random() + 100));
		} catch (Exception ex) {
			// ignore
		}

		TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance(":mainForm:timeline");

		Date startDate = e.getStartDateFirst(); // alias getStartDate() can be used too
		Date endDate = e.getEndDateFirst(); // alias getEndDate() can be used too

		// fetch events for the first time range
		generateRandomEvents(startDate, endDate, timelineUpdater);

		if (e.hasTwoRanges()) {
			// zooming out ==> fetch events for the second time range
			generateRandomEvents(e.getStartDateSecond(), e.getEndDateSecond(), timelineUpdater);
		}
	}

	private void generateRandomEvents(Date startDate, Date endDate, TimelineUpdater timelineUpdater) {
		Calendar cal = Calendar.getInstance();
		Date curDate = startDate;
		Random rnd = new Random();

		while (curDate.before(endDate)) {
			// create events in the given time range
			if (rnd.nextBoolean()) {
				// event with only one date
				model.add(new TimelineEvent("Event " + RandomStringUtils.randomNumeric(5), curDate), timelineUpdater);
			} else {
				// event with start and end dates
				cal.setTimeInMillis(curDate.getTime());
				cal.add(Calendar.HOUR, 18);
				model.add(new TimelineEvent("Event " + RandomStringUtils.randomNumeric(5), curDate, cal.getTime()),
				          timelineUpdater);
			}

			cal.setTimeInMillis(curDate.getTime());
			cal.add(Calendar.HOUR, 24);

			curDate = cal.getTime();
		}
	}

	public void clearTimeline() {
		// clear Timeline, so that it can be loaded again with a new preload factor
		model.clear();
	}

	public void setPreloadFactor(float preloadFactor) {
		this.preloadFactor = preloadFactor;
	}

	public float getPreloadFactor() {
		return preloadFactor;
	}

	public long getZoomMax() {
		return zoomMax;
	}
}
