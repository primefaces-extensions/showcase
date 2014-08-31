package org.primefaces.extensions.showcase.controller.gravatar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Example Bean for Gravatar component
 *
 * @author f.strazzullo
 */
@ManagedBean
@ViewScoped
public class GravatarController implements Serializable{

    private static final long serialVersionUID = 1L;

    private int size = 200;
    private String notFound = "default";
    private String username = "iamadummygravataruser@gmail.com";

    public String getNotFound() {
        return notFound;
    }

    public void setNotFound(String notFound) {
        this.notFound = notFound;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
