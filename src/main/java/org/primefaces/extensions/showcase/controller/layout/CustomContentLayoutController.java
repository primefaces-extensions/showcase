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

import org.primefaces.extensions.model.layout.LayoutOptions;

/**
 * CustomContentLayoutController
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class CustomContentLayoutController implements Serializable {

	private static final long serialVersionUID = 20120925L;

	private String src = "/sections/layout/example-customContentOne.xhtml";
	private LayoutOptions layoutOptions;

	@PostConstruct
	protected void initialize() {
		layoutOptions = new LayoutOptions();

		// options for all panes
		LayoutOptions panes = new LayoutOptions();
		panes.addOption("slidable", false);
		layoutOptions.setPanesOptions(panes);

		// north pane
		LayoutOptions north = new LayoutOptions();
		north.addOption("resizable", false);
		north.addOption("closable", false);
		north.addOption("size", 60);
		north.addOption("spacing_open", 0);
		layoutOptions.setNorthOptions(north);

		// south pane
		LayoutOptions south = new LayoutOptions();
		south.addOption("resizable", false);
		south.addOption("closable", false);
		south.addOption("size", 28);
		south.addOption("spacing_open", 0);
		layoutOptions.setSouthOptions(south);

		// west pane
		LayoutOptions west = new LayoutOptions();
		west.addOption("size", 340);
		west.addOption("minSize", 150);
		west.addOption("maxSize", 500);
		layoutOptions.setWestOptions(west);

		LayoutOptions center = new LayoutOptions();
		center.addOption("resizable", false);
		center.addOption("closable", false);
		center.addOption("minWidth", 200);
		center.addOption("minHeight", 60);
		layoutOptions.setCenterOptions(center);

		// set options for nested center layout
		LayoutOptions optionsNested = new LayoutOptions();
		center.setChildOptions(optionsNested);

		// options for center-north pane
		LayoutOptions centerNorth = new LayoutOptions();
		centerNorth.addOption("size", "50%");
		optionsNested.setNorthOptions(centerNorth);

		// options for center-center pane
		LayoutOptions centerCenter = new LayoutOptions();
		centerCenter.addOption("minHeight", 60);
		optionsNested.setCenterOptions(centerCenter);
	}

	public LayoutOptions getLayoutOptions() {
		return layoutOptions;
	}

	public String getSrc() {
		return src;
	}

	public void showMessages() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is the first error message", null);
		FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is the second error message", null);

		fc.addMessage(null, msg1);
		fc.addMessage(null, msg2);
	}

	public void hideMessages() {
		// nothing to do
	}
}
