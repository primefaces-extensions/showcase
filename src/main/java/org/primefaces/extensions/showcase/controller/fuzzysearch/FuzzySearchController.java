package org.primefaces.extensions.showcase.controller.fuzzysearch;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.extensions.showcase.model.system.AvailableThemes;
import org.primefaces.extensions.showcase.model.system.Theme;

@Named
@ViewScoped
public class FuzzySearchController implements Serializable {

    private static final long serialVersionUID = 20120224L;

    private List<Theme> themes;
    private Theme selectedTheme;

    @PostConstruct
    public void init() {
        themes = AvailableThemes.getInstance().getThemes();
    }

    public void onChange(AjaxBehaviorEvent event) {
        Theme theme = (Theme) ((UIOutput) event.getSource()).getValue();
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Select fired: Theme is " + theme.getName(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onSubmit(ActionEvent actionEvent) {
        final FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Select fired: Theme is " + selectedTheme.getName(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public Theme getSelectedTheme() {
        return selectedTheme;
    }

    public void setSelectedTheme(Theme selectedTheme) {
        this.selectedTheme = selectedTheme;
    }

}
