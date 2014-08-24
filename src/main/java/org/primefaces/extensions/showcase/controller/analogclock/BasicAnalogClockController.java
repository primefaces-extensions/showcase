package org.primefaces.extensions.showcase.controller.analogclock;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@RequestScoped
public class BasicAnalogClockController implements Serializable {

	private static final long serialVersionUID = -5427668306657486626L;
	
	private final Date now = new Date();

	public Date getNow() {
		return now;
	}

}
