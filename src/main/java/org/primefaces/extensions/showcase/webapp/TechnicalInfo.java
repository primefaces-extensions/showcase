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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

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
	private String buildTime;
	private boolean mojarra = true;

	private List<String> newComponents = new ArrayList<String>();
	private List<String> updatedComponents = new ArrayList<String>();

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
			primeFacesExt = "PrimeFaces Extensions: " + appProperties.get("primefaces-extensions.core.version");
			jsfImpl = "JSF: " + appProperties.get("jsf-impl") + " " + appProperties.get("jsf-version");
			server =
			    "Server: "
			    + ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getServerInfo();

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar calendar = Calendar.getInstance();

			if (appProperties.containsKey("timestamp")) {
				calendar.setTimeInMillis(Long.valueOf(appProperties.get("timestamp")));
			}

			buildTime = "Build time: " + formatter.format(calendar.getTime());
			mojarra = appProperties.get("jsf-impl").contains("mojarra");

			//mfenoglio process new and updated components
			this.proccessNewsComponents(appProperties.get("primefaces-extensions.new-components"),
			                            appProperties.get("primefaces-extensions.updated-components"));
		} catch (MissingResourceException e) {
			LOGGER.warning("Resource bundle 'pe-showcase' was not found");
		}
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

	public String getBuildTime() {
		return buildTime;
	}

	public boolean isMojarra() {
		return mojarra;
	}

	public String getMenuitemIconStyleClass(final String page) {
		if (newComponents.contains(page)) {
			return "ui-icon-new-comp";
		}

		if (updatedComponents.contains(page)) {
			return "ui-icon-updated-comp";
		}

		return "ui-icon-none";
	}

	private void proccessNewsComponents(final String newComp, final String updatedComp) {
		try {
			String[] newCompArray = newComp.split(";");
			Collections.addAll(newComponents, newCompArray);

			String[] updatedCompArray = updatedComp.split(";");
			Collections.addAll(updatedComponents, updatedCompArray);
		} catch (Exception ex) {
			this.newComponents = new ArrayList<String>();
			this.updatedComponents = new ArrayList<String>();
		}
	}
}
