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
 *
 * $Id$
 */

package org.primefaces.extensions.showcase.controller.exporter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * DynamicColumnsTableController
 *
 * @author  Sudheer Jonna / last modified by $Author$
 * @since   0.7.0
 * @version $Revision: 1.0 $
 */
@ManagedBean
@ViewScoped
public class DynamicColumnsTableController implements Serializable {

	private static final List<String> VALID_COLUMN_KEYS =
	    Arrays.asList("subject", "text", "country", "textLength", "deliveryStatus");

	private static final long serialVersionUID = 20111020L;

	private List<Message> messages;
	private List<Message> messageDetails;
	private List<Message> filteredMessages;

	private String columnTemplate = "subject text country textLength";
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();

	public DynamicColumnsTableController() {
		if (messages == null) {
			messages = new ArrayList<Message>();

			for (int i = 0; i < 10; i++) {
				Message message = new Message();
				message.setSubject("subject " + i);
				message.setText("text " + i);
				message.setTextLength(((i * 10) + 10) + "");
				message.setCountry("country" + i);
				message.setDeliveryStatus("successfull");
				messages.add(message);
			}
		}

		createDynamicColumns();
	}

	private String getRandomModel() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(final List<Message> messages) {
		this.messages = messages;
	}

	public List<Message> getFilteredMessages() {
		return filteredMessages;
	}

	public void setFilteredMessages(List<Message> filteredMessages) {
		this.filteredMessages = filteredMessages;
	}

	public static class ColumnModel implements Serializable {

		private String header;
		private String property;

		public ColumnModel(String header, String property) {
			this.header = header;
			this.property = property;
		}

		public String getHeader() {
			return header;
		}

		public String getProperty() {
			return property;
		}
	}


	public class Message implements Serializable {

		private String subject;
		private String text;
		private long time;
		private String textLength;
		private String country;
		private String deliveryStatus;

		public Message() {
			time = System.currentTimeMillis() + (long) (Math.random() * 10);
			textLength = Math.random() * 10 + "";
		}

		public final String getSubject() {
			return subject;
		}

		public final void setSubject(String subject) {
			this.subject = subject;
		}

		public final String getText() {
			return text;
		}

		public final void setText(String text) {
			this.text = text;
		}

		public long getTime() {
			return time;
		}

		public void setTime(long time) {
			this.time = time;
		}

		public String getTextLength() {
			return textLength;
		}

		public void setTextLength(String textLength) {
			this.textLength = textLength;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getDeliveryStatus() {
			return deliveryStatus;
		}

		public void setDeliveryStatus(String deliveryStatus) {
			this.deliveryStatus = deliveryStatus;
		}
	}

	public String getColumnTemplate() {
		return columnTemplate;
	}

	public void setColumnTemplate(String columnTemplate) {
		this.columnTemplate = columnTemplate;
	}

	public void updateColumns() {
		createDynamicColumns();
	}

	public void createDynamicColumns() {
		String[] columnKeys = columnTemplate.split(" ");
		columns.clear();

		for (String columnKey : columnKeys) {
			String key = columnKey.trim();

			if (VALID_COLUMN_KEYS.contains(key)) {
				columns.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
			}
		}
	}
}
