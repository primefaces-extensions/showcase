package org.primefaces.extensions.showcase.controller.timer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
public class BasicTimerController implements Serializable{

    public void onTimeout(){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"BOOM",null));
    }

}
