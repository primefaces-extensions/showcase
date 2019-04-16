package org.primefaces.extensions.showcase.controller.timer;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class BasicTimerController implements Serializable{

    public void onTimeout(){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"BOOM",null));
    }

}
