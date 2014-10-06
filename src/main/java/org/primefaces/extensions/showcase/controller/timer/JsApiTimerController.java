package org.primefaces.extensions.showcase.controller.timer;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
public class JsApiTimerController implements Serializable{

    public void listener(){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Stopped",null));
    }

}
