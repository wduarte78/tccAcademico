package ui.bean;

import entity.TipoMovimentacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoMovimentacaoController")
@ViewScoped
public class TipoMovimentacaoController extends AbstractController<TipoMovimentacao> {

    @Inject
    private TipoPedidoController idTipoPedidoController;
    @Inject
    private FuncionarioController idFuncionarioController;

    public TipoMovimentacaoController() {
        // Inform the Abstract parent controller of the concrete TipoMovimentacao?cap_first Entity
        super(TipoMovimentacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTipoPedidoController.setSelected(null);
        idFuncionarioController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoPedido controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoPedido(ActionEvent event) {
        if (this.getSelected() != null && idTipoPedidoController.getSelected() == null) {
            idTipoPedidoController.setSelected(this.getSelected().getIdTipoPedido());
        }
    }

    /**
     * Sets the "selected" attribute of the Funcionario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFuncionario(ActionEvent event) {
        if (this.getSelected() != null && idFuncionarioController.getSelected() == null) {
            idFuncionarioController.setSelected(this.getSelected().getIdFuncionario());
        }
    }
}
