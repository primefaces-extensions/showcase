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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.event.CompleteEvent;

/**
 * CodeMirrorController
 *
 * @author  Thomas Andraschko / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class CodeMirrorController implements Serializable {

	private static final long serialVersionUID = 20111020L;

	private String content;
	private String mode = "javascript";

	public CodeMirrorController() {
		content = "function test() { console.log('test'); }";
	}

	public void changeMode() {
		if (mode.equals("css")) {
			mode = "javascript";
		} else {
			mode = "css";
		}
	}

	public List<String> complete(final CompleteEvent event) {
		final ArrayList<String> suggestions = new ArrayList<String>();

		suggestions.add("context: " + event.getContext());
		suggestions.add("token: " + event.getToken());

		return suggestions;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(final String mode) {
		this.mode = mode;
	}
}
