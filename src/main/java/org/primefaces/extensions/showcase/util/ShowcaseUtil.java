/*
 * Copyright 2011-2012 PrimeFaces Extensions.
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

package org.primefaces.extensions.showcase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.faces.context.FacesContext;

/**
 * ShowcaseUtil
 *
 * @author  Pavol Slany / last modified by $Author$
 * @version $Revision$
 */
public class ShowcaseUtil {

	private static final String[] START_MARKERS = {"@ManagedBean", "@RequestScoped", "@ViewScoped", "@SessionScoped", " class "};

	public static String getFileContent(final String fullPathToFile) {
		try {
			// Finding in WEB ...
			FacesContext fc = FacesContext.getCurrentInstance();
			InputStream is = fc.getExternalContext().getResourceAsStream(fullPathToFile);
			if (is != null) {
				return convertStreamToString(is, false);
			}

			// Finding in ClassPath ...
			is = ShowcaseUtil.class.getResourceAsStream(fullPathToFile);
			if (is != null) {
				return convertStreamToString(is, true);
			}
		} catch (Exception e) {
			throw new IllegalStateException("Internal error: file " + fullPathToFile + " could not be read", e);
		}

		return "";
	}

	private static String convertStreamToString(final InputStream is, final boolean classPath) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();
		String line;

		if (classPath) {
			boolean foundStart = false;
			line = br.readLine();

			while (line != null && !foundStart) {
				for (String startMarker : START_MARKERS) {
					if (line.contains(startMarker)) {
						foundStart = true;

						break;
					}
				}

				if (!foundStart) {
					line = br.readLine();
				}
			}

			if (foundStart) {
				sb.append(line);
			} else {
				throw new IllegalStateException("Internal error: start marker for an Java file to be output is not found!");
			}
		}

		line = br.readLine();
		while (line != null) {
			sb.append("\n");
			sb.append(line);
			line = br.readLine();
		}

		return sb.toString().trim();
	}
}
