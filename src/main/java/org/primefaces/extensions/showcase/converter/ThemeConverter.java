/*
 * Copyright (C) 2012 Scalaris AG, Germany. All rights reserved.
 *
 * $Id$
 */

package org.primefaces.extensions.showcase.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.extensions.showcase.model.system.AvailableThemes;
import org.primefaces.extensions.showcase.model.system.Theme;

/**
 * ThemeConverter
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@FacesConverter("org.primefaces.extensions.showcase.converter.ThemeConverter")
public class ThemeConverter implements Converter {

	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		return AvailableThemes.getInstance().getThemeForName(value);
	}

	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		return ((Theme) value).getName();
	}
}
