/*
 * Copyright 2012 PrimeFaces Extensions.
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

package org.primefaces.extensions.showcase.controller.tristatecheckbox;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * TriStateCheckBoxController
 *
 * @author  Mauricio Fenoglio / last modified by $Author$
 * @version $Revision$
 * @since   0.3
 */
@ManagedBean
@ViewScoped
public class TriStateCheckBoxController implements Serializable {

	private static final long serialVersionUID = 20110302L;

	private String value1;
	private String value2;
	private String value3;
	private String value4;

	public TriStateCheckBoxController() {
		value1 = "2";
		value4 = "1";
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public void addMessage() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed", "State is = " + value2);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
