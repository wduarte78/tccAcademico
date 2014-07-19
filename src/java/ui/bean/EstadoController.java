package ui.bean;

import entity.Estado;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estadoController")
@ViewScoped
public class EstadoController extends AbstractController<Estado> {

    @Inject
    private CidadeController cidadeCollectionController;
    @Inject
    private PaisController codPaisController;
    @Inject
    private EnderecoController enderecoCollectionController;

    public EstadoController() {
        // Inform the Abstract parent controller of the concrete Estado?cap_first Entity
        super(Estado.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codPaisController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Cidade entities that are
     * retrieved from Estado?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cidade page
     */
    public String navigateCidadeCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cidade_items", this.getSelected().getCidadeCollection());
        }
        return "/entity/cidade/index";
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodPais(ActionEvent event) {
        if (this.getSelected() != null && codPaisController.getSelected() == null) {
            codPaisController.setSelected(this.getSelected().getCodPais());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Endereco entities that
     * are retrieved from Estado?cap_first and returns the navigation outcome.
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
