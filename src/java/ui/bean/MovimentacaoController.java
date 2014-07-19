package ui.bean;

import entity.Movimentacao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "movimentacaoController")
@ViewScoped
public class MovimentacaoController extends AbstractController<Movimentacao> {

    @Inject
    private LocalOperacaoController localOperacaoidLocalOperacaoController;
    @Inject
    private FuncionarioController responsavelController;
    @Inject
    private ClasseController idClasseController;
    @Inject
    private StatusArmazemController statusArmazemCollectionController;

    public MovimentacaoController() {
        // Inform the Abstract parent controller of the concrete Movimentacao?cap_first Entity
        super(Movimentacao.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        localOperacaoidLocalOperacaoController.setSelected(null);
        responsavelController.setSelected(null);
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the LocalOperacao controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLocalOperacaoidLocalOperacao(ActionEvent event) {
        if (this.getSelected() != null && localOperacaoidLocalOperacaoController.getSelected() == null) {
            localOperacaoidLocalOperacaoController.setSelected(this.getSelected().getLocalOperacaoidLocalOperacao());
        }
    }

    /**
     * Sets the "selected" attribute of the Funcionario controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareResponsavel(ActionEvent event) {
        if (this.getSelected() != null && responsavelController.getSelected() == null) {
            responsavelController.setSelected(this.getSelected().getResponsavel());
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
     * Sets the "items" attribute with a collection of StatusArmazem entities
     * that are retrieved from Movimentacao?cap_first and returns the navigation
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

}
