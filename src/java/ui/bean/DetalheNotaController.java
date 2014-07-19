package ui.bean;

import entity.DetalheNota;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detalheNotaController")
@ViewScoped
public class DetalheNotaController extends AbstractController<DetalheNota> {

    @Inject
    private TipoEquipamentoController tipoEquipamentoidTipoEquipamentoController;
    @Inject
    private FornecedorController fornecedoridFornecedorController;
    @Inject
    private EmbalagemController embalagemidEmbalgemController;
    @Inject
    private ClasseController idClasseController;
    @Inject
    private TipoPedidoController tipoPedidoCollectionController;
    @Inject
    private TipoPedidoController tipoPedidoCollection1Controller;

    public DetalheNotaController() {
        // Inform the Abstract parent controller of the concrete DetalheNota?cap_first Entity
        super(DetalheNota.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoEquipamentoidTipoEquipamentoController.setSelected(null);
        fornecedoridFornecedorController.setSelected(null);
        embalagemidEmbalgemController.setSelected(null);
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoEquipamento controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoEquipamentoidTipoEquipamento(ActionEvent event) {
        if (this.getSelected() != null && tipoEquipamentoidTipoEquipamentoController.getSelected() == null) {
            tipoEquipamentoidTipoEquipamentoController.setSelected(this.getSelected().getTipoEquipamentoidTipoEquipamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Fornecedor controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFornecedoridFornecedor(ActionEvent event) {
        if (this.getSelected() != null && fornecedoridFornecedorController.getSelected() == null) {
            fornecedoridFornecedorController.setSelected(this.getSelected().getFornecedoridFornecedor());
        }
    }

    /**
     * Sets the "selected" attribute of the Embalagem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEmbalagemidEmbalgem(ActionEvent event) {
        if (this.getSelected() != null && embalagemidEmbalgemController.getSelected() == null) {
            embalagemidEmbalgemController.setSelected(this.getSelected().getEmbalagemidEmbalgem());
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

    /**
     * Sets the "items" attribute with a collection of TipoPedido entities that
     * are retrieved from DetalheNota?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoPedido page
     */
    public String navigateTipoPedidoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoPedido_items", this.getSelected().getTipoPedidoCollection());
        }
        return "/entity/tipoPedido/index";
    }

    /**
     * Sets the "items" attribute with a collection of TipoPedido entities that
     * are retrieved from DetalheNota?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoPedido page
     */
    public String navigateTipoPedidoCollection1() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoPedido_items", this.getSelected().getTipoPedidoCollection1());
        }
        return "/entity/tipoPedido/index";
    }

}
