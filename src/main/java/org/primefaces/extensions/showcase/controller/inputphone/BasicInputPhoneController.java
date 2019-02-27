package org.primefaces.extensions.showcase.controller.inputphone;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.extensions.model.inputphone.Country;

/**
 *
 * @author Jasper de Vries &lt;jepsar@gmail.com&gt;
 */
@ManagedBean
@ViewScoped
public class BasicInputPhoneController implements Serializable {

    private String phoneNumber;

    public void onCountrySelect(SelectEvent event) {
        Country country = (Country) event.getObject();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected "+ country.getName(), null));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
