package ui.bean;

import entity.Material;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "materialController")
@ViewScoped
public class MaterialController extends AbstractController<Material> {

    @Inject
    private EmbalagemController embalagemCollectionController;

    public MaterialController() {
        // Inform the Abstract parent controller of the concrete Material?cap_first Entity
        super(Material.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Embalagem entities that
     * are retrieved from Material?cap_first and returns the navigation outcome.
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
