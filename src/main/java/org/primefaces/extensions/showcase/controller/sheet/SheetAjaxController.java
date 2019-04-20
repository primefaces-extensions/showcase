package org.primefaces.extensions.showcase.controller.sheet;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.primefaces.extensions.component.sheet.Sheet;
import org.primefaces.extensions.event.SheetEvent;
import org.primefaces.extensions.model.sheet.SheetUpdate;

/**
 * {@link Sheet} Ajax Controller.
 *
 * @author Melloware mellowaredev@gmail.com
 */
@ManagedBean
@ViewScoped
public class SheetAjaxController extends SheetController {

    private static final long serialVersionUID = 20120224L;

    /**
     * Ajax callback from the Sheet component when a cell value is changed.
     */
    @Override
    public void cellChangeEvent(final SheetEvent event) {
        final Sheet sheet = event.getSheet();
        final List<SheetUpdate> updates = sheet.getUpdates();
        for (final SheetUpdate sheetUpdate : updates) {
            final Long id = (Long) sheetUpdate.getRowKey();
            final Object oldValue = sheetUpdate.getOldValue();
            final Object newValue = sheetUpdate.getNewValue();

            FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Update Success", String.format("Asset %s updated. Old Value = %s, New Value = %s", id, oldValue, newValue)));
            break; // just show 1 update
        }
        sheet.commitUpdates();
    }

    /**
     * Ajax callback from the Sheet component when a column is selected.
     */
    public void columnSelectEvent(final SheetEvent event) {
        final Sheet sheet = event.getSheet();
        final int column = sheet.getSelectedColumn() + 1;
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Column Selected", String.format("Column %d selected.", column)));
    }

    /**
     * Ajax callback from the Sheet component when a row is selected.
     */
    public void rowSelectEvent(final SheetEvent event) {
        final Sheet sheet = event.getSheet();
        final int row = sheet.getSelectedRow() + 1;
        FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Row Selected", String.format("Row %d selected.", row)));
    }

    public void validateExactly5(final FacesContext context, final UIComponent comp, final Object value) {
        final Integer integer = (Integer) value;
        if (integer.intValue() != 5) {
            final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Value must only be 5 exactly!");
            throw new ValidatorException(message);
        }
    }

}
