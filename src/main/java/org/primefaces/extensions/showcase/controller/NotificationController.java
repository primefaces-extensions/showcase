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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * NotificationController
 *
 * @author  Thomas Andraschko / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@RequestScoped
public class NotificationController {

	public void addInfoMessage() {
		final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "This is a \"Info\" message", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addErrorMessage() {
		final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "This is a Error message", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addWarnMessage() {
		final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "This is a <br/>Warn<br/> message", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addFatalMessage() {
		final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "This is a 'Fatal' message", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
