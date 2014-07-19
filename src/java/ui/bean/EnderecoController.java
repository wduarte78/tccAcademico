package ui.bean;

import entity.Endereco;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "enderecoController")
@ViewScoped
public class EnderecoController extends AbstractController<Endereco> {

    @Inject
    private FornecedorController fornecedorCollectionController;
    @Inject
    private FuncionarioController funcionarioCollectionController;
    @Inject
    private PaisController codPaisController;
    @Inject
    private EstadoController codEstadoController;
    @Inject
    private CidadeController codCidadeController;

    public EnderecoController() {
        // Inform the Abstract parent controller of the concrete Endereco?cap_first Entity
        super(Endereco.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        codPaisController.setSelected(null);
        codEstadoController.setSelected(null);
        codCidadeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Fornecedor entities that
     * are retrieved from Endereco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fornecedor page
     */
    public String navigateFornecedorCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fornecedor_items", this.getSelected().getFornecedorCollection());
        }
        return "/entity/fornecedor/index";
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Endereco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcionario page
     */
    public String navigateFuncionarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcionario_items", this.getSelected().getFuncionarioCollection());
        }
        return "/entity/funcionario/index";
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
     * Sets the "selected" attribute of the Cidade controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCodCidade(ActionEvent event) {
        if (this.getSelected() != null && codCidadeController.getSelected() == null) {
            codCidadeController.setSelected(this.getSelected().getCodCidade());
        }
    }
}
