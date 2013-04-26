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

package org.primefaces.extensions.showcase.controller.layout;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.extensions.component.layout.LayoutPane;
import org.primefaces.extensions.event.CloseEvent;
import org.primefaces.extensions.event.OpenEvent;
import org.primefaces.extensions.event.ResizeEvent;
import org.primefaces.extensions.model.layout.LayoutOptions;

/**
 * LayoutController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class FullLayoutController implements Serializable {

	private static final long serialVersionUID = 20120925L;

	private LayoutOptions layoutOptions;

	@PostConstruct
	protected void initialize() {
		layoutOptions = new LayoutOptions();

		// options for all panes
		LayoutOptions panes = new LayoutOptions();
		panes.addOption("slidable", false);
		panes.addOption("resizeWhileDragging", false);
		layoutOptions.setPanesOptions(panes);

		// options for center pane
		LayoutOptions center = new LayoutOptions();
		layoutOptions.setCenterOptions(center);

		// options for nested center layout
		LayoutOptions childCenterOptions = new LayoutOptions();
		center.setChildOptions(childCenterOptions);

		// options for center-north pane
		LayoutOptions centerNorth = new LayoutOptions();
		centerNorth.addOption("size", "50%");
		childCenterOptions.setNorthOptions(centerNorth);

		// options for center-center pane
		LayoutOptions centerCenter = new LayoutOptions();
		centerCenter.addOption("minHeight", 60);
		childCenterOptions.setCenterOptions(centerCenter);

		// options for west pane
		LayoutOptions west = new LayoutOptions();
		west.addOption("size", 200);
		layoutOptions.setWestOptions(west);

		// options for nested west layout
		LayoutOptions childWestOptions = new LayoutOptions();
		west.setChildOptions(childWestOptions);

		// options for west-north pane
		LayoutOptions westNorth = new LayoutOptions();
		westNorth.addOption("size", "33%");
		childWestOptions.setNorthOptions(westNorth);

		// options for west-center pane
		LayoutOptions westCenter = new LayoutOptions();
		westCenter.addOption("minHeight", "60");
		childWestOptions.setCenterOptions(westCenter);

		// options for west-south pane
		LayoutOptions westSouth = new LayoutOptions();
		westSouth.addOption("size", "33%");
		childWestOptions.setSouthOptions(westSouth);

		// options for east pane
		LayoutOptions east = new LayoutOptions();
		east.addOption("size", 200);
		layoutOptions.setEastOptions(east);

		// options for south pane
		LayoutOptions south = new LayoutOptions();
		south.addOption("size", 80);
		layoutOptions.setSouthOptions(south);
	}

	public LayoutOptions getLayoutOptions() {
		return layoutOptions;
	}

	public void handleClose(CloseEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane closed",
		                     "Position:" + ((LayoutPane) event.getComponent()).getPosition());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void handleOpen(OpenEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane opened",
		                     "Position:" + ((LayoutPane) event.getComponent()).getPosition());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void handleResize(ResizeEvent event) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane resized",
		                     "Position:" + ((LayoutPane) event.getComponent()).getPosition() + ", new width = "
		                     + event.getWidth() + "px, new height = " + event.getHeight() + "px");

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
