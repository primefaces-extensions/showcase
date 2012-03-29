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

import javax.faces.context.FacesContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ShowcaseUtil
 *
 * @author  Pavol Slany / last modified by $Author$
 * @version $Revision$
 */
public class ShowcaseUtil {

	public static String getFileContentFromWeb(String fileName) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			InputStream is = fc.getExternalContext().getResourceAsStream(fileName);

			return convertStreamToString(is);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getFileContentFromClasspath(String fileName) {
		try {
			InputStream is = ShowcaseUtil.class.getResourceAsStream(fileName);

			return convertStreamToString(is);
		} catch (Exception e) {
			return null;
		}
	}

	private static String convertStreamToString(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = br.readLine();
		while (line != null) {
		    sb.append("\n");
			sb.append(line);
            line = br.readLine();
		}

		return sb.toString().trim();
	}
}
