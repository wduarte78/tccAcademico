package ui.bean;

import entity.Produto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "produtoController")
@ViewScoped
public class ProdutoController extends AbstractController<Produto> {

    @Inject
    private NumOnuController idNumOnuController;
    @Inject
    private FornecedorController idFornecedorController;
    @Inject
    private ClasseController idClasseController;

    public ProdutoController() {
        // Inform the Abstract parent controller of the concrete Produto?cap_first Entity
        super(Produto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idNumOnuController.setSelected(null);
        idFornecedorController.setSelected(null);
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the NumOnu controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdNumOnu(ActionEvent event) {
        if (this.getSelected() != null && idNumOnuController.getSelected() == null) {
            idNumOnuController.setSelected(this.getSelected().getIdNumOnu());
        }
    }

    /**
     * Sets the "selected" attribute of the Fornecedor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFornecedor(ActionEvent event) {
        if (this.getSelected() != null && idFornecedorController.getSelected() == null) {
            idFornecedorController.setSelected(this.getSelected().getIdFornecedor());
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
