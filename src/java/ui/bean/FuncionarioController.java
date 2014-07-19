package ui.bean;

import entity.Funcionario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "funcionarioController")
@ViewScoped
public class FuncionarioController extends AbstractController<Funcionario> {

    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private UsersController idUserController;
    @Inject
    private RolerController idRoleController;
    @Inject
    private EnderecoController enderecoidEnderecoController;
    @Inject
    private TipoMovimentacaoController tipoMovimentacaoCollectionController;

    public FuncionarioController() {
        // Inform the Abstract parent controller of the concrete Funcionario?cap_first Entity
        super(Funcionario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idUserController.setSelected(null);
        idRoleController.setSelected(null);
        enderecoidEnderecoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from Funcionario?cap_first and returns the navigation
     * outcome.
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
     * Sets the "selected" attribute of the Users controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUser(ActionEvent event) {
        if (this.getSelected() != null && idUserController.getSelected() == null) {
            idUserController.setSelected(this.getSelected().getIdUser());
        }
    }

    /**
     * Sets the "selected" attribute of the Roler controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdRole(ActionEvent event) {
        if (this.getSelected() != null && idRoleController.getSelected() == null) {
            idRoleController.setSelected(this.getSelected().getIdRole());
        }
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

    /**
     * Sets the "items" attribute with a collection of TipoMovimentacao entities
     * that are retrieved from Funcionario?cap_first and returns the navigation
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

}
