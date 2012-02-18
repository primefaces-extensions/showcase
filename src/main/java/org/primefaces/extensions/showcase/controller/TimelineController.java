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
package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline.DefaultTimeLine;
import org.primefaces.extensions.model.timeline.DefaultTimelineEvent;
import org.primefaces.extensions.model.timeline.Timeline;

/**
 *
 * @author Nilesh Mali / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class TimelineController implements Serializable {

    private List<Timeline> timelines;

    public List<Timeline> getTimelines() {
        timelines = new ArrayList<Timeline>();
        Calendar cal = Calendar.getInstance();
        Timeline timeline = new DefaultTimeLine("2011", "2011");
        cal.set(2011, 03, 10);
        timeline.addEvent(new DefaultTimelineEvent("Project Created", "Primefaces Extensions Project Created", cal.getTime(), cal.getTime()));
        cal.set(2011, 05, 10);
        timeline.addEvent(new DefaultTimelineEvent("Primefaces Extensions 0.1 Released", "PE tagged first release 0.1", cal.getTime(), cal.getTime()));
        cal.set(2011, 07, 14);
        timeline.addEvent(new DefaultTimelineEvent("New member Oleg Varaksin", "Oleg Varaksin has joined our team", cal.getTime(), cal.getTime()));
        timelines.add(timeline);

        timeline = new DefaultTimeLine("2012", "2012");
        cal.set(2012, 01, 17);
        timeline.addEvent(new DefaultTimelineEvent("New member Nilesh Mali", "Nilesh Mali has joined our team", cal.getTime(), cal.getTime()));
        cal.set(2012, 01, 23);
        timeline.addEvent(new DefaultTimelineEvent("Primefaces Extensions 0.2.0 Released", "Primefaces Extensions second release 0.2.0", cal.getTime(), cal.getTime()));
        cal.set(2012, 02, 14);
        timeline.addEvent(new DefaultTimelineEvent("New member Mauricio Fenoglio", "Mauricio Fenoglio has joined our team", cal.getTime(), cal.getTime()));
        timelines.add(timeline);
        return timelines;
    }
}
