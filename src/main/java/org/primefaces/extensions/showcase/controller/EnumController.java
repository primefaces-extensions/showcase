package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.extensions.showcase.model.ComponentLibrary;

@ManagedBean
@ViewScoped
public class EnumController implements Serializable {

	private List<ComponentLibrary> available;
	private List<ComponentLibrary> selected;

	public EnumController() {
		available = new ArrayList<ComponentLibrary>();
		selected = new ArrayList<ComponentLibrary>();

		for (final ComponentLibrary library : ComponentLibrary.values()) {
			available.add(library);
		}
	}

	public final List<ComponentLibrary> getAvailable() {
		return available;
	}

	public final void setAvailable(final List<ComponentLibrary> available) {
		this.available = available;
	}

	public final List<ComponentLibrary> getSelected() {
		return selected;
	}

	public final void setSelected(final List<ComponentLibrary> selected) {
		this.selected = selected;
	}
}
