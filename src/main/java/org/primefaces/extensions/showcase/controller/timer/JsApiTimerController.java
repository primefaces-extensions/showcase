package org.primefaces.extensions.showcase.controller.timer;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class JsApiTimerController implements Serializable{

    public void listener(){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Stopped",null));
    }

}
