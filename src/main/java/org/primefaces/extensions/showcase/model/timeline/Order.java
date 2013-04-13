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
 * Data object for order (truck example) in the Timeline examples.
 *
 * @author  Oleg Varaksin / last modified by $Author: $
 * @version $Revision: 1.0 $
 */
public class Order implements Serializable {

	private int number;
	private String imagePath;

	public Order(int number, String imagePath) {
		this.number = number;
		this.imagePath = imagePath;
	}

	public int getNumber() {
		return number;
	}

	public String getImagePath() {
		return imagePath;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Order order = (Order) o;

		if (number != order.number) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return number;
	}
}
