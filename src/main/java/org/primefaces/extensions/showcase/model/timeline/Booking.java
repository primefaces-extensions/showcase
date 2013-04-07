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

package org.primefaces.extensions.showcase.model.timeline;

import java.io.Serializable;

/**
 * Data object for room booking in the Timeline examples.
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
public class Booking implements Serializable {

	private int roomNumber;
	private RoomCategory category;
	private String phone;
	private String comment;

	public Booking(int roomNumber, RoomCategory category, String phone, String comment) {
		this.roomNumber = roomNumber;
		this.category = category;
		this.phone = phone;
		this.comment = comment;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public RoomCategory getCategory() {
		return category;
	}

	public String getPhone() {
		return phone;
	}

	public String getComment() {
		return comment;
	}
}
