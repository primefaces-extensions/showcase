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

package org.primefaces.extensions.showcase.controller.resetinput;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * ResetInputController
 *
 * @author  Thomas Andraschko / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class ResetInputController implements Serializable {

	private String firstValue;
	private String secondValue;

	public final String getFirstValue() {
		return firstValue;
	}

	public final void setFirstValue(String value) {
		this.firstValue = value;
	}

	public final String getSecondValue() {
		return secondValue;
	}

	public final void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

	public void handleChangeValue() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Value changed", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
