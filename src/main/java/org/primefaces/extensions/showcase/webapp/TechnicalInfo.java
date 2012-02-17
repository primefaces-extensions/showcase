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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
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

	private String primeFaces;
	private String primeFacesExt;
	private String jsfImpl;
	private String server;
	private String revision;
	private String buildTime;
	private boolean online = false;
	private boolean mojarra = true;

	@PostConstruct
	protected void initialize() {
		ResourceBundle rb;
		try {
			rb = ResourceBundle.getBundle("pe-showcase");

			String strAppProps = rb.getString("application.properties");
			int lastBrace = strAppProps.indexOf("}");
			strAppProps = strAppProps.substring(1, lastBrace);

			Map<String, String> appProperties = new HashMap<String, String>();
			String[] appProps = strAppProps.split("[\\s,]+");
			for (String appProp : appProps) {
				String[] keyValue = appProp.split("=");
				if (keyValue != null && keyValue.length > 1) {
					appProperties.put(keyValue[0], keyValue[1]);
				}
			}

			primeFaces = "PrimeFaces: " + appProperties.get("primefaces.core.version");
			primeFacesExt = "PrimeFaces Extensions: " + appProperties.get("pe.impl.version");
			jsfImpl = "JSF-Impl.: " + appProperties.get("pe.jsf.displayname") + " " + appProperties.get("pe.jsf.version");
			server = "Server: Jetty " + appProperties.get("jetty.server.version");
			revision = "SVN-Revision: " + appProperties.get("svn.revision");

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(Long.valueOf(appProperties.get("timestamp")));
			buildTime = "Build time: " + formatter.format(calendar.getTime());

			online = Boolean.valueOf(appProperties.get("pe.webapp.online"));
			mojarra = appProperties.get("pe.jsf.impl").contains("mojarra");
		} catch (MissingResourceException e) {
			LOGGER.warning("Resource bundle 'pe-showcase' was not found");
		}
	}

	public boolean isOnline() {
		return online;
	}

	public String getPrimeFaces() {
		return primeFaces;
	}

	public String getPrimeFacesExt() {
		return primeFacesExt;
	}

	public String getJsfImpl() {
		return jsfImpl;
	}

	public String getServer() {
		return server;
	}

	public String getRevision() {
		return revision;
	}

	public String getBuildTime() {
		return buildTime;
	}

	public boolean isMojarra() {
		return mojarra;
	}
}
