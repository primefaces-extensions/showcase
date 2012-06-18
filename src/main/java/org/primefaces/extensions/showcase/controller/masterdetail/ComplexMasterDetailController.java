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

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

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

	private List<Person> persons;
	private List<SelectItem> availableLanguageSkills = null;
	private List<String> selectedLanguageSkills = new ArrayList<String>();
	private String languageSkillToAdd;

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

	public List<SelectItem> getAvailableLanguageSkills() {
		if (availableLanguageSkills == null) {
			availableLanguageSkills = new ArrayList<SelectItem>();
			availableLanguageSkills.add(new SelectItem("English", "English"));
			availableLanguageSkills.add(new SelectItem("German", "German"));
			availableLanguageSkills.add(new SelectItem("Russian", "Russian"));
			availableLanguageSkills.add(new SelectItem("Turkish", "Turkish"));
			availableLanguageSkills.add(new SelectItem("Dutch", "Dutch"));
			availableLanguageSkills.add(new SelectItem("French", "French"));
			availableLanguageSkills.add(new SelectItem("Italian", "Italian"));
		}

		return availableLanguageSkills;
	}

	public List<String> getSelectedLanguageSkills() {
		return selectedLanguageSkills;
	}

	public void setLanguageSkillToAdd(String languageSkillToAdd) {
		this.languageSkillToAdd = languageSkillToAdd;
	}

	public String getLanguageSkillToAdd() {
		return languageSkillToAdd;
	}

	public String saveSuccess(Person person) {
		FacesMessage message =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Person " + person.getName() + " has been saved", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

		return null;
	}

	public String saveFailure(Person person) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elContext = fc.getELContext();

		SelectLevelListener selectLevelListener;
		try {
			selectLevelListener =
			    (SelectLevelListener) elContext.getELResolver().getValue(elContext, null, "selectLevelListener");
			selectLevelListener.setErrorOccured(true);
		} catch (RuntimeException e) {
			throw new FacesException(e.getMessage(), e);
		}

		FacesMessage message =
		    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Person " + person.getName() + " could not be saved", null);
		FacesContext.getCurrentInstance().addMessage(null, message);

		return null;
	}

	public String delete(Person person) {
		for (Person pers : persons) {
			if (pers.getId().equals(person.getId())) {
				persons.remove(pers);

				break;
			}
		}

		return null;
	}

	public void addLanguageSkill(Person person) {
		if (languageSkillToAdd != null) {
			person.addLanguageSkill(languageSkillToAdd);
		}

		languageSkillToAdd = null;
	}
}
