package ui.bean;

import entity.TipoPedido;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoPedidoController")
@ViewScoped
public class TipoPedidoController extends AbstractController<TipoPedido> {

    @Inject
    private TipoMovimentacaoController tipoMovimentacaoCollectionController;
    @Inject
    private DetalheNotaController idDetalheNotaController;
    @Inject
    private DetalheNotaController detalheNotaidDetalheNotaController;

    public TipoPedidoController() {
        // Inform the Abstract parent controller of the concrete TipoPedido?cap_first Entity
        super(TipoPedido.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDetalheNotaController.setSelected(null);
        detalheNotaidDetalheNotaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TipoMovimentacao entities
     * that are retrieved from TipoPedido?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoMovimentacao page
     */
    public String navigateTipoMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoMovimentacao_items", this.getSelected().getTipoMovimentacaoCollection());
        }
        return "/entity/tipoMovimentacao/index";
    }

    /**
     * Sets the "selected" attribute of the DetalheNota controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDetalheNota(ActionEvent event) {
        if (this.getSelected() != null && idDetalheNotaController.getSelected() == null) {
            idDetalheNotaController.setSelected(this.getSelected().getIdDetalheNota());
        }
    }

    /**
     * Sets the "selected" attribute of the DetalheNota controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDetalheNotaidDetalheNota(ActionEvent event) {
        if (this.getSelected() != null && detalheNotaidDetalheNotaController.getSelected() == null) {
            detalheNotaidDetalheNotaController.setSelected(this.getSelected().getDetalheNotaidDetalheNota());
        }
    }
}
