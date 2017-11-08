package org.primefaces.extensions.showcase.controller.speedtest;

/**
 * {@link Speedtest} Controller.
 *
 * @author Stefan Sibitz ssibitz@me.com
 */
import org.primefaces.extensions.event.SpeedTestEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Random;

@ManagedBean
@ViewScoped
public class SpeedTestController implements Serializable {
    private static final long serialVersionUID = -5297177555931103300L;
    private static final String alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Integer OneMB = 1024 * 1024;
    // Size of Download-File (Default=5)
    private Integer sizeInMB = 5;

    public void SaveResults(SpeedTestEvent speedTestEvent) {
        String msg =    "PingTimeMS       ='"+String.valueOf(speedTestEvent.getPingTimeMS()) + "', \n"+
                        "Jitter           ='"+String.valueOf(speedTestEvent.getJitterTimeMS()) + "', \n" +
                        "SpeedMbpsDownload='"+String.valueOf(speedTestEvent.getSpeedMbpsDownload()) + "', \n" +
                        "SpeedMbpsUpload='"+String.valueOf(speedTestEvent.getSpeedMbpsUpload()) +"'";
        FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved your speed results:", msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private String GeneratePayloadFile() {
        // Generate random test string
        StringBuffer randomTestString = new StringBuffer();
        Integer size2Generate = OneMB*sizeInMB;
        Integer N = alphabet .length();
        Random r = new Random();
        for (int i = 0; i < size2Generate; i++) {
            randomTestString.append(alphabet.charAt(r.nextInt(N)));
        }
        return randomTestString.toString();
    }

    public void DownloadPayloadFile() {
        String payloadString = GeneratePayloadFile();
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
            response.reset();
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=dummy.payload");
            response.getWriter().write(payloadString);
            response.getWriter().flush();
            facesContext.responseComplete();
        }
        catch (Exception e) {
            // ignore
        }
    }

    public void UpdateSizeInMB() {
        // Dummy for updating the size on the server...
    }

    public Integer getSizeInMB() {
        return sizeInMB;
    }

    public void setSizeInMB(Integer sizeInMB) {
        this.sizeInMB = sizeInMB;
    }
}
