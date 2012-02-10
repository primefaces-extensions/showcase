/*
 * Copyright 2011 PrimeFaces Extensions.
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

package org.primefaces.extensions.showcase.controller.masterdetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.showcase.model.Person;

/**
 * ComplexMasterDetailController.
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class ComplexMasterDetailController implements Serializable {

	private static final long serialVersionUID = 20111120L;

	private Person selectedPerson;
	private List<Person> persons;

	public ComplexMasterDetailController() {
		if (persons == null) {
			persons = new ArrayList<Person>();

			Calendar calendar = Calendar.getInstance();
			calendar.set(1972, 5, 25);
			persons.add(new Person("1", "Max Mustermann", 1, calendar.getTime()));
			calendar.set(1981, 12, 10);
			persons.add(new Person("2", "Sara Schmidt", 2, calendar.getTime()));
			calendar.set(1968, 2, 13);
			persons.add(new Person("3", "Jasper Morgan", 3, calendar.getTime()));
		}
	}

	public List<Person> getPersons() {
		return persons;
	}
}
