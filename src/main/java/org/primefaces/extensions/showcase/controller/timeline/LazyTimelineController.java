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
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.event.timeline.TimelineLazyLoadEvent;
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

	@PostConstruct
	protected void initialize() {
		model = new TimelineModel();
	}

	public TimelineModel getModel() {
		return model;
	}

	public void onLazyLoad(TimelineLazyLoadEvent e) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println("================================");
		System.out.println("StartDateFirst = " + (e.getStartDateFirst() == null ? "null"
		                                                                        : format.format(e.getStartDateFirst())));
		System.out.println("EndDateFirst = " + (e.getEndDateFirst() == null ? "null" : format.format(e.getEndDateFirst())));
		System.out.println("StartDateSecond = "
		                   + (e.getStartDateSecond() == null ? "null" : format.format(e.getStartDateSecond())));
		System.out.println("EndDateSecond = " + (e.getEndDateSecond() == null ? "null" : format.format(e.getEndDateSecond())));
	}
}
