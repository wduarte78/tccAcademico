package ui.bean;

import entity.Legenda;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "legendaController")
@ViewScoped
public class LegendaController extends AbstractController<Legenda> {

    @Inject
    private ClasseController classeCollectionController;

    public LegendaController() {
        // Inform the Abstract parent controller of the concrete Legenda?cap_first Entity
        super(Legenda.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Classe entities that are
     * retrieved from Legenda?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Classe page
     */
    public String navigateClasseCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Classe_items", this.getSelected().getClasseCollection());
        }
        return "/entity/classe/index";
    }

}
