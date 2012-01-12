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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
@SessionScoped
public class LayoutController implements Serializable {

	private static final long serialVersionUID = 20120108L;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
}
