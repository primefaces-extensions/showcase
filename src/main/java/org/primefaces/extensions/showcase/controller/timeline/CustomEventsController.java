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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.model.timeline.DefaultTimeLine;
import org.primefaces.extensions.model.timeline.DefaultTimelineEvent;
import org.primefaces.extensions.model.timeline.Timeline;
import org.primefaces.extensions.model.timeline.TimelineEvent;

/**
 *
 * @author Nilesh Mali / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class CustomEventsController implements Serializable {

    private List<Timeline> timelines;
    private TimelineEvent selectedEvent;


    public CustomEventsController(){
        timelines = new ArrayList<Timeline>();
        Calendar cal = Calendar.getInstance();
        Timeline timeline = new DefaultTimeLine("customEventTimeline", "Primefaces Release History");
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
        timelines.add(timeline);
    }

    public void onEventSelect(SelectEvent event){
        selectedEvent = (TimelineEvent) event.getObject();
    }

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public TimelineEvent getSelectedEvent() {
        return selectedEvent;
    }
}
