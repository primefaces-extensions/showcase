/*
 * Copyright 2011-2012 PrimeFaces Extensions.
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

package org.primefaces.extensions.showcase.controller.dynaform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.primefaces.extensions.showcase.model.dynaform.BookProperty;

/**
 * DynaFormController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class DynaFormController implements Serializable {

	private static final long serialVersionUID = 20120423L;

	private DynaFormModel model;

	private static List<SelectItem> LANGUAGES = new ArrayList<SelectItem>();

	@PostConstruct
	protected void initialize() {
		model = new DynaFormModel();

		// add rows, labels and editable controls
		// set relationship between label and editable controls to support outputLabel with "for" attribute

		// 1. row
		DynaFormRow row = model.createRegularRow();

		DynaFormLabel label11 = row.addLabel("Author");
		DynaFormControl control12 = row.addControl(new BookProperty("Author", true), "input");
		label11.setForControl(control12);

		DynaFormLabel label13 = row.addLabel("ISBN");
		DynaFormControl control14 = row.addControl(new BookProperty("ISBN", true), "input");
		label13.setForControl(control14);

		// 2. row
		row = model.createRegularRow();

		DynaFormLabel label21 = row.addLabel("Title");
		DynaFormControl control22 = row.addControl(new BookProperty("Title", false), "input", 3, 1);
		label21.setForControl(control22);

		// 3. row
		row = model.createRegularRow();

		DynaFormLabel label31 = row.addLabel("Publisher");
		DynaFormControl control32 = row.addControl(new BookProperty("Publisher", false), "input");
		label31.setForControl(control32);

		DynaFormLabel label33 = row.addLabel("Published on");
		DynaFormControl control34 = row.addControl(new BookProperty("Published on", false), "calendar");
		label33.setForControl(control34);

		// 4. row
		row = model.createRegularRow();

		DynaFormLabel label41 = row.addLabel("Language");
		DynaFormControl control42 = row.addControl(new BookProperty("Language", false), "select");
		label41.setForControl(control42);

		DynaFormLabel label43 = row.addLabel("Description", 1, 2);
		DynaFormControl control44 = row.addControl(new BookProperty("Description", false), "textarea", 1, 2);
		label43.setForControl(control44);

		// 5. row
		row = model.createRegularRow();

		DynaFormLabel label51 = row.addLabel("Rating");
		DynaFormControl control52 = row.addControl(new BookProperty("Rating", 3, true), "rating");
		label51.setForControl(control52);
	}

	public DynaFormModel getModel() {
		return model;
	}

	public List<BookProperty> getBookProperties() {
		if (model == null) {
			return null;
		}

		List<BookProperty> bookProperties = new ArrayList<BookProperty>();
		for (DynaFormControl dynaFormControl : model.getControls()) {
			bookProperties.add((BookProperty) dynaFormControl.getData());
		}

		return bookProperties;
	}

	public String submitForm() {
		FacesMessage.Severity sev = FacesContext.getCurrentInstance().getMaximumSeverity();
		boolean hasErrors = (sev != null && (FacesMessage.SEVERITY_ERROR.compareTo(sev) >= 0));

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.addCallbackParam("isValid", !hasErrors);

		return null;
	}

	public List<SelectItem> getLanguages() {
		if (LANGUAGES.isEmpty()) {
			LANGUAGES.add(new SelectItem("en", "English"));
			LANGUAGES.add(new SelectItem("de", "German"));
			LANGUAGES.add(new SelectItem("ru", "Russian"));
			LANGUAGES.add(new SelectItem("tr", "Turkish"));
		}

		return LANGUAGES;
	}
}
