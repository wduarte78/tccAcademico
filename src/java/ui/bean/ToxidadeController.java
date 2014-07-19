package ui.bean;

import entity.Toxidade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "toxidadeController")
@ViewScoped
public class ToxidadeController extends AbstractController<Toxidade> {

    public ToxidadeController() {
        // Inform the Abstract parent controller of the concrete Toxidade?cap_first Entity
        super(Toxidade.class);
    }

}
