package org.primefaces.extensions.showcase.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SwitchController {

	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
}

