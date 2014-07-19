package ui.bean;

import entity.Grupoembalagem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "grupoembalagemController")
@ViewScoped
public class GrupoembalagemController extends AbstractController<Grupoembalagem> {

    @Inject
    private EmbalagemController embalagemCollectionController;

    public GrupoembalagemController() {
        // Inform the Abstract parent controller of the concrete Grupoembalagem?cap_first Entity
        super(Grupoembalagem.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Grupoembalagem?cap_first and returns the navigation
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
