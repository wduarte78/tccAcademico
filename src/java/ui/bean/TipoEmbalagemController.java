package ui.bean;

import entity.TipoEmbalagem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "tipoEmbalagemController")
@ViewScoped
public class TipoEmbalagemController extends AbstractController<TipoEmbalagem> {

    @Inject
    private EmbalagemController embalagemCollectionController;

    public TipoEmbalagemController() {
        // Inform the Abstract parent controller of the concrete TipoEmbalagem?cap_first Entity
        super(TipoEmbalagem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from TipoEmbalagem?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Embalagem page
     */
    public String navigateEmbalagemCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Embalagem_items", this.getSelected().getEmbalagemCollection());
        }
        return "/entity/embalagem/index";
    }

}
