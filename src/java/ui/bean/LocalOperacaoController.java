package ui.bean;

import entity.LocalOperacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "localOperacaoController")
@ViewScoped
public class LocalOperacaoController extends AbstractController<LocalOperacao> {

    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private ClasseController idClasseController;

    public LocalOperacaoController() {
        // Inform the Abstract parent controller of the concrete LocalOperacao?cap_first Entity
        super(LocalOperacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from LocalOperacao?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Movimentacao page
     */
    public String navigateMovimentacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Movimentacao_items", this.getSelected().getMovimentacaoCollection());
        }
        return "/entity/movimentacao/index";
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
