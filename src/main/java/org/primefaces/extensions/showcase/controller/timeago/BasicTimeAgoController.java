package org.primefaces.extensions.showcase.controller.timeago;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jasper de Vries &lt;jepsar@gmail.com&gt;
 */
@ManagedBean
@ViewScoped
public class BasicTimeAgoController implements Serializable {

    private Date now;

    private Date firstRelease;

    public BasicTimeAgoController() {
        now = new Date();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2012, 0, 23);
        firstRelease = calendar.getTime();
    }

    public Date getNow() {
        return now;
    }

    public Date getFirstRelease() {
        return firstRelease;
    }

}
