package org.primefaces.extensions.showcase.controller.timeago;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Jasper de Vries &lt;jepsar@gmail.com&gt;
 */
@ManagedBean
@ViewScoped
public class LocalizedTimeAgoController implements Serializable {

    private Date now;

    private Date firstRelease;

    private String locale;

    public LocalizedTimeAgoController() {
        now = new Date();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2012, 0, 23);
        firstRelease = calendar.getTime();

        locale = "en";
    }

    public List<SelectItem> getLanguages() {
        final List<SelectItem> results = new ArrayList<>();
        results.add(new SelectItem("de", "Deutsch (German)"));
        results.add(new SelectItem("en", "English"));
        results.add(new SelectItem("es", "Español (Spanish)"));
        results.add(new SelectItem("fr", "Français (French)"));
        results.add(new SelectItem("it", "Italiano (Italian)"));
        results.add(new SelectItem("nl", "Nederlands (Dutch)"));
        return results;
    }

    public Date getNow() {
        return now;
    }

    public Date getFirstRelease() {
        return firstRelease;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}
