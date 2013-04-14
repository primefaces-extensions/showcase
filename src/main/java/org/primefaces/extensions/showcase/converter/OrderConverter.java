/*
 * Copyright 2011-2013 PrimeFaces Extensions.
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
 */

package org.primefaces.extensions.showcase.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.showcase.model.timeline.Order;

/**
 * OrderConverter
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@FacesConverter("org.primefaces.extensions.showcase.converter.OrderConverter")
public class OrderConverter implements Converter, Serializable {

	private List<TimelineEvent> events;

	public OrderConverter() {
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (StringUtils.isBlank(value) || events == null || events.isEmpty()) {
			return null;
		}

		for (TimelineEvent event : events) {
			if (((Order) event.getData()).getNumber() == Integer.valueOf(value)) {
				return event;
			}
		}

		return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		return String.valueOf(((Order) ((TimelineEvent) value).getData()).getNumber());
	}

	public List<TimelineEvent> getEvents() {
		return events;
	}

	public void setEvents(List<TimelineEvent> events) {
		this.events = events;
	}
}
