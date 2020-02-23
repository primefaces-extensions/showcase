package org.primefaces.extensions.showcase.controller.renderer;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jasper de Vries &lt;jepsar@gmail.com&gt;
 */
@Named
@ViewScoped
public class RendererController implements Serializable {

    private static final long serialVersionUID = 1L;

    public void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
