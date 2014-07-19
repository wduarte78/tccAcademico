package ui.bean;

import entity.Embalagem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "embalagemController")
@ViewScoped
public class EmbalagemController extends AbstractController<Embalagem> {

    @Inject
    private TipoEmbalagemController tipoEmbalagemidTipoEmbalagemController;
    @Inject
    private MaterialController materialidMaterialController;
    @Inject
    private GrupoembalagemController grupoembalagemidGrupoembalagemController;
    @Inject
    private ClasseController idClasseController;
    @Inject
    private DetalheNotaController detalheNotaCollectionController;

    public EmbalagemController() {
        // Inform the Abstract parent controller of the concrete Embalagem?cap_first Entity
        super(Embalagem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoEmbalagemidTipoEmbalagemController.setSelected(null);
        materialidMaterialController.setSelected(null);
        grupoembalagemidGrupoembalagemController.setSelected(null);
        idClasseController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoEmbalagem controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoEmbalagemidTipoEmbalagem(ActionEvent event) {
        if (this.getSelected() != null && tipoEmbalagemidTipoEmbalagemController.getSelected() == null) {
            tipoEmbalagemidTipoEmbalagemController.setSelected(this.getSelected().getTipoEmbalagemidTipoEmbalagem());
        }
    }

    /**
     * Sets the "selected" attribute of the Material controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMaterialidMaterial(ActionEvent event) {
        if (this.getSelected() != null && materialidMaterialController.getSelected() == null) {
            materialidMaterialController.setSelected(this.getSelected().getMaterialidMaterial());
        }
    }

    /**
     * Sets the "selected" attribute of the Grupoembalagem controller in order
     * to display its data in a dialog. This is reusing existing the existing
     * View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGrupoembalagemidGrupoembalagem(ActionEvent event) {
        if (this.getSelected() != null && grupoembalagemidGrupoembalagemController.getSelected() == null) {
            grupoembalagemidGrupoembalagemController.setSelected(this.getSelected().getGrupoembalagemidGrupoembalagem());
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
     * Sets the "items" attribute with a collection of DetalheNota entities that
     * are retrieved from Embalagem?cap_first and returns the navigation
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

}
