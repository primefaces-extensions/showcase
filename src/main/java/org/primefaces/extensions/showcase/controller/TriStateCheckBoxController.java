/*
 * Copyright (C) 2012 Scalaris AG, Germany. All rights reserved.
 *
 * $Id: $
 */

/*
 * $Id
 */

package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * TriStateCheckBoxController
 *
 * @author  Mauricio Fenoglio / last modified by $Author: $
 * @version $Revision: $
 * @since   0.3
 */
@ManagedBean
@ViewScoped
public class TriStateCheckBoxController implements Serializable {

	private String value1;
	private String value2;
	private String value3;

	private Boolean valueB1;
	private Boolean valueB2;

	public TriStateCheckBoxController() {
		value1 = "2";
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

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public Boolean getValueB1() {
		return valueB1;
	}

	public void setValueB1(Boolean valueB1) {
		this.valueB1 = valueB1;
	}

	public Boolean getValueB2() {
		return valueB2;
	}

	public void setValueB2(Boolean valueB2) {
		this.valueB2 = valueB2;
	}

	public void addMessage() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "State has been changed", "State is = " + value2);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
