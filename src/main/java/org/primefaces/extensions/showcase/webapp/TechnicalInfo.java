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

package org.primefaces.extensions.showcase.webapp;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * TechnicalInfo.
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ApplicationScoped
@ManagedBean(eager = true)
public class TechnicalInfo {

	private static final Logger LOGGER = Logger.getLogger(TechnicalInfo.class.getName());

	private String version;
	private String revision;
	private String buildTime;
	private String javaRuntime;

	protected void initialize() {
		ResourceBundle rb;
		try {
			rb = ResourceBundle.getBundle("appinfo");
		} catch (MissingResourceException e) {
			LOGGER.warning("Resource bundle 'appinfo' was not found");

			return;
		}

		version = getTechValue(rb, "Implementation-Version");
		revision = getTechValue(rb, "Implementation-Build");
		buildTime = getTechValue(rb, "Build-Time");
		javaRuntime = System.getProperty("java.version");
	}

	public String getVersion() {
		return version;
	}

	public String getRevision() {
		return revision;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public String getJavaRuntime() {
		return javaRuntime;
	}

	public boolean isRunningOnMojarra() {
		// TODO
		return true;
	}

	private String getTechValue(final ResourceBundle rb, final String key) {
		try {
			return rb.getString(key);
		} catch (MissingResourceException e) {
			return "???" + key + "???";
		}
	}
}
