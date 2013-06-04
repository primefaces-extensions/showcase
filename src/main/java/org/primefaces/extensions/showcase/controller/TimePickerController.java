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

package org.primefaces.extensions.showcase.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.extensions.event.BeforeShowEvent;
import org.primefaces.extensions.event.CloseEvent;
import org.primefaces.extensions.event.TimeSelectEvent;

/**
 * TimePickerController
 *
 * @author  ova / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@ViewScoped
public class TimePickerController implements Serializable {

	private static final long serialVersionUID = 20120224L;

	private Date time1;
	private Date time2;
	private Date time3;
	private Date time4;
	private Date time5;
    private Date time6;
	private boolean showTime = false;

	public TimePickerController() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 8);
		calendar.set(Calendar.MINUTE, 15);
		time1 = calendar.getTime();

		calendar.set(Calendar.HOUR, 11);
		calendar.set(Calendar.MINUTE, 40);
		time2 = calendar.getTime();

		time3 = new Date();

		time5 = new Date();
        
        time6 = new Date();
	}

	public Date getTime1() {
		return time1;
	}

	public void setTime1(Date time1) {
		this.time1 = time1;
	}

	public Date getTime2() {
		return time2;
	}

	public void setTime2(Date time2) {
		this.time2 = time2;
	}

	public Date getTime3() {
		return time3;
	}

	public void setTime3(Date time3) {
		this.time3 = time3;
	}

	public Date getTime4() {
		return time4;
	}

	public void setTime4(Date time4) {
		this.time4 = time4;
	}

	public Date getTime5() {
		return time5;
	}

	public void setTime5(Date time5) {
		this.time5 = time5;
	}

    public Date getTime6() {
        return time6;
    }

    public void setTime6(Date time6) {
        this.time6 = time6;
    }

    public String getFormattedTime1() {
		return getFormattedTime(time1, "HH:mm");
	}

	public String getFormattedTime2() {
		return getFormattedTime(time2, "HH:mm");
	}

	public String getFormattedTime3() {
		return getFormattedTime(time3, "HH:mm");
	}

	public String getFormattedTime4() {
		return getFormattedTime(time4, "hh-mm a");
	}

	public String getFormattedTime5() {
		return getFormattedTime(time5, "HH:mm");
	}
    
    public String getFormattedTime6() {
   		return getFormattedTime(time6, "HH:mm");
   	}    

	public void showTime(ActionEvent ae) {
		showTime = true;
	}

	public boolean isShowTimeDialog() {
		if (showTime) {
			showTime = false;

			return true;
		}

		return false;
	}

	public void timeSelectListener(TimeSelectEvent timeSelectEvent) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Time select fired",
		                     "Selected time: " + getFormattedTime(timeSelectEvent.getTime(), "HH:mm"));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void beforeShowListener(BeforeShowEvent beforeShowEvent) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Before show fired",
		                     "Component id: " + beforeShowEvent.getComponent().getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void closeListener(CloseEvent closeEvent) {
		FacesMessage msg =
		    new FacesMessage(FacesMessage.SEVERITY_INFO, "Close fired", "Component id: " + closeEvent.getComponent().getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private String getFormattedTime(Date time, String format) {
		if (time == null) {
			return null;
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		return simpleDateFormat.format(time);
	}
}
