package ui.bean;

import entity.Armazem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "armazemController")
@ViewScoped
public class ArmazemController extends AbstractController<Armazem> {

    @Inject
    private StatusArmazemController statusArmazemCollectionController;
    @Inject
    private EndArmazemController idEnderecoController;
    @Inject
    private ClasseController idClasseController;

    public ArmazemController() {
        // Inform the Abstract parent controller of the concrete Armazem?cap_first Entity
        super(Armazem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEnderecoController.setSelected(null);
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of StatusArmazem entities
     * that are retrieved from Armazem?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for StatusArmazem page
     */
    public String navigateStatusArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("StatusArmazem_items", this.getSelected().getStatusArmazemCollection());
        }
        return "/entity/statusArmazem/index";
    }

    /**
     * Sets the "selected" attribute of the EndArmazem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEndereco(ActionEvent event) {
        if (this.getSelected() != null && idEnderecoController.getSelected() == null) {
            idEnderecoController.setSelected(this.getSelected().getIdEndereco());
        }
    }

    /**
     * Sets the "selected" attribute of the Classe controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdClasse(ActionEvent event) {
        if (this.getSelected() != null && idClasseController.getSelected() == null) {
            idClasseController.setSelected(this.getSelected().getIdClasse());
        }
    }
}
