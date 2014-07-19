package ui.bean;

import entity.Fornecedor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "fornecedorController")
@ViewScoped
public class FornecedorController extends AbstractController<Fornecedor> {

    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private DetalheNotaController detalheNotaCollectionController;
    @Inject
    private EnderecoController enderecoidEnderecoController;

    public FornecedorController() {
        // Inform the Abstract parent controller of the concrete Fornecedor?cap_first Entity
        super(Fornecedor.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        enderecoidEnderecoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Fornecedor?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Produto page
     */
    public String navigateProdutoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Produto_items", this.getSelected().getProdutoCollection());
        }
        return "/entity/produto/index";
    }

    /**
     * Sets the "items" attribute with a collection of DetalheNota entities that
     * are retrieved from Fornecedor?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for DetalheNota page
     */
    public String navigateDetalheNotaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DetalheNota_items", this.getSelected().getDetalheNotaCollection());
        }
        return "/entity/detalheNota/index";
    }

    /**
     * Sets the "selected" attribute of the Endereco controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEnderecoidEndereco(ActionEvent event) {
        if (this.getSelected() != null && enderecoidEnderecoController.getSelected() == null) {
            enderecoidEnderecoController.setSelected(this.getSelected().getEnderecoidEndereco());
        }
    }
}
