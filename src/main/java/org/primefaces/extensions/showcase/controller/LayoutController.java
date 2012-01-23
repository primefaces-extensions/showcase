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
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.extensions.component.layout.LayoutPane;
import org.primefaces.extensions.event.CloseEvent;
import org.primefaces.extensions.event.OpenEvent;
import org.primefaces.extensions.event.ResizeEvent;

/**
 * LayoutController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class LayoutController implements Serializable {

	private static final long serialVersionUID = 20120108L;

	private String stateOne;
	private String stateTwo;
	private boolean layoutOneShown = true;
	private List<MenuItem> tabs = null;

	public String getStateOne() {
		return stateOne;
	}

	public void setStateOne(String stateOne) {
		this.stateOne = stateOne;
	}

	public String getStateTwo() {
		return stateTwo;
	}

	public void setStateTwo(String stateTwo) {
		this.stateTwo = stateTwo;
	}

	public void toogleLayout(ActionEvent event) {
		layoutOneShown = !layoutOneShown;
	}

	public boolean isLayoutOneShown() {
		return layoutOneShown;
	}

	public void handleClose(CloseEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane closed",
		                     "Position:'" + ((LayoutPane) event.getComponent()).getPosition() + "'");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void handleOpen(OpenEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane opened",
		                     "Position:'" + ((LayoutPane) event.getComponent()).getPosition() + "'");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void handleResize(ResizeEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane resized",
		                     "Position:'" + ((LayoutPane) event.getComponent()).getPosition() + "', new width = "
		                     + event.getWidth() + "px, new height = " + event.getHeight() + "px");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<MenuItem> getLayoutTabs() {
		if (tabs == null) {
			tabs = new ArrayList<MenuItem>();

			MenuItem mi = new MenuItem();
			mi.setUrl("/sections/layout/examples/management.xhtml");
			mi.setIcon("ui-icon-wrench");
			mi.setValue("Management");
			tabs.add(mi);

			mi = new MenuItem();
			mi.setUrl("/sections/layout/examples/settings.xhtml");
			mi.setIcon("ui-icon-gear");
			mi.setValue("Settings");
			tabs.add(mi);

			mi = new MenuItem();
			mi.setUrl("/sections/layout/examples/about.xhtml");
			mi.setIcon("ui-icon-info");
			mi.setValue("About");
			tabs.add(mi);
		}

		return tabs;
	}
}
