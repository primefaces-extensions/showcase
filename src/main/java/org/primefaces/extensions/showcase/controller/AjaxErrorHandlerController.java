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

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * AjaxErrorHandlerController
 *
 * @author  Pavol Slany / last modified by $Author$
 * @version $Revision$
 * @since   0.5
 */
@ManagedBean
@RequestScoped
public class AjaxErrorHandlerController {

	public String actionThrowNullPointer() {
		throw new NullPointerException("This is my null pointer exception!");
	}

	public String actionWrappedException() {
		Throwable t = new IllegalStateException("This is wrapped illegal state exception!");
		throw new FacesException(t);
	}

	public String actionSimulateViewExpiredException() {
		throw new ViewExpiredException("This is simulated ViewExpiredException",
		                               FacesContext.getCurrentInstance().getViewRoot().getViewId());
	}
}
