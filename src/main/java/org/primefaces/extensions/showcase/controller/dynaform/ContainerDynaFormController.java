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

package org.primefaces.extensions.showcase.controller.dynaform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.primefaces.extensions.showcase.model.dynaform.FormField;

/**
 * ContainerDynaFormController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class ContainerDynaFormController implements Serializable {

	private static final long serialVersionUID = 20130426L;

	private DynaFormModel model;
	private List<SelectItem> list;
	private FormField selectedField;
	private String selectedItem;
	private String containerClientId; // container clientId of the currently handled input field

	@PostConstruct
	protected void initialize() {
		list = new ArrayList<SelectItem>();
		list.add(new SelectItem("Item 1", "Item 1"));
		list.add(new SelectItem("Item 2", "Item 2"));
		list.add(new SelectItem("Item 3", "Item 3"));
		list.add(new SelectItem("Item 4", "Item 4"));

		model = new DynaFormModel();

		// add rows, labels and editable controls
		// set relationship between label and editable controls to support outputLabel with "for" attribute

		// 1. row
		DynaFormRow row = model.createRegularRow();

		DynaFormLabel label11 = row.addLabel("Input 1");
		DynaFormControl control12 = row.addControl(new FormField("Some text"));
		label11.setForControl(control12);

		DynaFormLabel label13 = row.addLabel("Input 2");
		DynaFormControl control14 = row.addControl(new FormField("Some text"));
		label13.setForControl(control14);

		// 2. row
		row = model.createRegularRow();

		DynaFormLabel label21 = row.addLabel("Input 3");
		DynaFormControl control22 = row.addControl(new FormField("Some text"));
		label21.setForControl(control22);

		DynaFormLabel label23 = row.addLabel("Input 4");
		DynaFormControl control24 = row.addControl(new FormField("Some text"));
		label23.setForControl(control24);
	}

	public void updateSelection() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();

		// update selected item value for the currently handled field
		selectedField.setValue(selectedItem);

		// update the corresponding input field in UI
		rc.update(containerClientId + UINamingContainer.getSeparatorChar(fc) + "txt");
	}

	public List<String> getValues() {
		if (model == null) {
			return null;
		}

		List<String> values = new ArrayList<String>();
		for (DynaFormLabel dynaFormLabel : model.getLabels()) {
			values.add(dynaFormLabel.getValue() + ": " +
                   ((FormField) dynaFormLabel.getForControl().getData()).getValue());
		}

		return values;
	}

	public DynaFormModel getModel() {
		return model;
	}

	public List<SelectItem> getList() {
		return list;
	}

	public FormField getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(FormField selectedField) {
		this.selectedField = selectedField;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public String getContainerClientId() {
		return containerClientId;
	}

	public void setContainerClientId(String containerClientId) {
		this.containerClientId = containerClientId;
	}
}
