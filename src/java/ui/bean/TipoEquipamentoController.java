package ui.bean;

import entity.TipoEquipamento;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoEquipamentoController")
@ViewScoped
public class TipoEquipamentoController extends AbstractController<TipoEquipamento> {

    @Inject
    private DetalheNotaController detalheNotaCollectionController;
    @Inject
    private VeiculoController veiculoidVeiculoController;
    @Inject
    private EpiController epiidEpiController;
    @Inject
    private EpeController epeidEpeController;

    public TipoEquipamentoController() {
        // Inform the Abstract parent controller of the concrete TipoEquipamento?cap_first Entity
        super(TipoEquipamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        veiculoidVeiculoController.setSelected(null);
        epiidEpiController.setSelected(null);
        epeidEpeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DetalheNota entities that
     * are retrieved from TipoEquipamento?cap_first and returns the navigation
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
     * Sets the "selected" attribute of the Veiculo controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareVeiculoidVeiculo(ActionEvent event) {
        if (this.getSelected() != null && veiculoidVeiculoController.getSelected() == null) {
            veiculoidVeiculoController.setSelected(this.getSelected().getVeiculoidVeiculo());
        }
    }

    /**
     * Sets the "selected" attribute of the Epi controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEpiidEpi(ActionEvent event) {
        if (this.getSelected() != null && epiidEpiController.getSelected() == null) {
            epiidEpiController.setSelected(this.getSelected().getEpiidEpi());
        }
    }

    /**
     * Sets the "selected" attribute of the Epe controller in order to display
     * its data in a dialog. This is reusing existing the existing View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEpeidEpe(ActionEvent event) {
        if (this.getSelected() != null && epeidEpeController.getSelected() == null) {
            epeidEpeController.setSelected(this.getSelected().getEpeidEpe());
        }
    }
}
