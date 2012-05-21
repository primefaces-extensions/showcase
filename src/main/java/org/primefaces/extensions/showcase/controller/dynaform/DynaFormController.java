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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.primefaces.extensions.showcase.model.dynaform.BookProperty;
import org.primefaces.extensions.showcase.model.dynaform.Label;

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

	public DynaFormController() {
		model = new DynaFormModel();

		DynaFormRow row = model.createRegularRow();

		/*
		private String title;
		private String publisher;
		private Date publicationDate;
		private String language;
		private String description;
		 */

		// add labels and editable controls
		// set relationship between label and editable controls in order to support outputLabel with "for" attribute

		// row 1
		DynaFormControl label11 = row.addControl(new Label("Author"), "label", 1, 1, true);
		DynaFormControl edit12 = row.addControl(new BookProperty("author", true), "input", 1, 1);
		label11.setRefKey(edit12.getKey());

		DynaFormControl label13 = row.addControl(new Label("ISBN"), "label", 1, 1, true);
		DynaFormControl edit14 = row.addControl(new BookProperty("isbn", false), "input", 1, 1);
		label13.setRefKey(edit14.getKey());
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
			if (dynaFormControl.getData() instanceof BookProperty) {
				bookProperties.add((BookProperty) dynaFormControl.getData());
			}
		}

		return bookProperties;
	}
}
