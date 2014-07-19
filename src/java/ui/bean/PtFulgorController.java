package ui.bean;

import entity.PtFulgor;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "ptFulgorController")
@ViewScoped
public class PtFulgorController extends AbstractController<PtFulgor> {

    public PtFulgorController() {
        // Inform the Abstract parent controller of the concrete PtFulgor?cap_first Entity
        super(PtFulgor.class);
    }

}
