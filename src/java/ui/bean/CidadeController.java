package ui.bean;

import entity.Cidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cidadeController")
@ViewScoped
public class CidadeController extends AbstractController<Cidade> {

    @Inject
    private EstadoController codEstadoController;
    @Inject
    private EnderecoController enderecoCollectionController;

    public CidadeController() {
        // Inform the Abstract parent controller of the concrete Cidade?cap_first Entity
        super(Cidade.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codEstadoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Estado controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodEstado(ActionEvent event) {
        if (this.getSelected() != null && codEstadoController.getSelected() == null) {
            codEstadoController.setSelected(this.getSelected().getCodEstado());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Endereco entities that
     * are retrieved from Cidade?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Endereco page
     */
    public String navigateEnderecoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Endereco_items", this.getSelected().getEnderecoCollection());
        }
        return "/entity/endereco/index";
    }

}
