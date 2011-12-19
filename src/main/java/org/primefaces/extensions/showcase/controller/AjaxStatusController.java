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

package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 * AjaxStatusController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class AjaxStatusController implements Serializable {

	private static final long serialVersionUID = 20111218L;

	private String country1 = "Germany";
	private String country2 = "Russia";
	private String food1 = "Pizza";
	private String food2 = "Kebab";
	private String text = "Try to type something";

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getCountry2() {
		return country2;
	}

	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	public String getFood1() {
		return food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void valueChanged(ValueChangeEvent vce) {
		try {
			// simulate a long running request
			Thread.sleep(1500);
		} catch (Exception e) {
			// ignore
		}
	}

	public void textChanged(ValueChangeEvent vce) {
		try {
			// simulate a long running request
			Thread.sleep(500);
		} catch (Exception e) {
			// ignore
		}
	}
}
