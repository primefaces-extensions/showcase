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

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * AutoCompleteController
 *
 * @author  Thomas Andraschko / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@RequestScoped
public class AutoCompleteController {

	private String text;

	public List<String> complete(final String query) {
		final List<String> results = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}
}
