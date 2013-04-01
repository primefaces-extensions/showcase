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

/**
 * LimitTimelineRangeController
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class LimitTimelineRangeController implements Serializable {

	private TimelineModel model;

	private Date min;
	private Date max;
	private long zoomMin;
	private long zoomMax;

	@PostConstruct
	protected void initialize() {
		model = new TimelineModel();

		Calendar cal = Calendar.getInstance();
		cal.set(2012, Calendar.MAY, 25, 0, 0, 0);
		model.add(new TimelineEvent("First", cal.getTime()));

		cal.set(2012, Calendar.MAY, 26, 0, 0, 0);
		model.add(new TimelineEvent("Last", cal.getTime()));

		// lower limit of visible range
		cal.set(2012, Calendar.JANUARY, 1, 0, 0, 0);
		min = cal.getTime();

		// upper limit of visible range
		cal.set(2012, Calendar.DECEMBER, 31, 0, 0, 0);
		max = cal.getTime();

		// one day in milliseconds for zoomMin
		zoomMin = 1000L * 60 * 60 * 24;

		// about three months in milliseconds for zoomMax
		zoomMax = 1000L * 60 * 60 * 24 * 31 * 3;
	}

	public TimelineModel getModel() {
		return model;
	}

	public Date getMin() {
		return min;
	}

	public Date getMax() {
		return max;
	}

	public long getZoomMin() {
		return zoomMin;
	}

	public long getZoomMax() {
		return zoomMax;
	}
}
