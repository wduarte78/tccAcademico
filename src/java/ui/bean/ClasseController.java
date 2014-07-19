package ui.bean;

import entity.Classe;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "classeController")
@ViewScoped
public class ClasseController extends AbstractController<Classe> {

    @Inject
    private ProdutoController produtoCollectionController;
    @Inject
    private EmbalagemController embalagemCollectionController;
    @Inject
    private MovimentacaoController movimentacaoCollectionController;
    @Inject
    private DetalheNotaController detalheNotaCollectionController;
    @Inject
    private LocalOperacaoController localOperacaoCollectionController;
    @Inject
    private LegendaController idLegendaController;
    @Inject
    private ArmazemController armazemCollectionController;

    public ClasseController() {
        // Inform the Abstract parent controller of the concrete Classe?cap_first Entity
        super(Classe.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idLegendaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Produto entities that are
     * retrieved from Classe?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Classe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entity/embalagem/index";
    }

    /**
     * Sets the "items" attribute with a collection of Movimentacao entities
     * that are retrieved from Classe?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of DetalheNota entities that
     * are retrieved from Classe?cap_first and returns the navigation outcome.
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
     * Sets the "items" attribute with a collection of LocalOperacao entities
     * that are retrieved from Classe?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for LocalOperacao page
     */
    public String navigateLocalOperacaoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("LocalOperacao_items", this.getSelected().getLocalOperacaoCollection());
        }
        return "/entity/localOperacao/index";
    }

    /**
     * Sets the "selected" attribute of the Legenda controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdLegenda(ActionEvent event) {
        if (this.getSelected() != null && idLegendaController.getSelected() == null) {
            idLegendaController.setSelected(this.getSelected().getIdLegenda());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Armazem entities that are
     * retrieved from Classe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Armazem page
     */
    public String navigateArmazemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Armazem_items", this.getSelected().getArmazemCollection());
        }
        return "/entity/armazem/index";
    }

}
