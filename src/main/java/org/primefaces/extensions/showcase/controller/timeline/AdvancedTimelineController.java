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
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.timeline.DefaultTimeLine;
import org.primefaces.extensions.model.timeline.DefaultTimelineEvent;
import org.primefaces.extensions.model.timeline.Timeline;

/**
 * @author Nilesh Mali / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class AdvancedTimelineController implements Serializable {
    private List<Timeline> timelines;

    public List<Timeline> getTimelines() {
        timelines = new ArrayList<Timeline>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 1);
        Date start, end;
        for (int group = 1; group <= 5; group++) {
            Timeline timeline = new DefaultTimeLine("Group" + group);
            cal.setTime(new Date());
            cal.set(Calendar.HOUR_OF_DAY, 1);
            for (int event = 1; event < 6; event++) {
                cal.add(Calendar.HOUR_OF_DAY, 1 + 4 * ((Math.random() < 0.2) ? 1 : 0));
                start = cal.getTime();
                cal.add(Calendar.HOUR_OF_DAY, 2 + (int) (Math.floor(Math.random() * 4)));
                end = cal.getTime();
                timeline.addEvent(new DefaultTimelineEvent("Event " + event, start, (Math.random() < 0.25) ? null : end));
            }
            timelines.add(timeline);
        }
        return timelines;
    }
}
