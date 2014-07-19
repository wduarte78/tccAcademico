package ui.bean;

import entity.PtEbulicao;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "ptEbulicaoController")
@ViewScoped
public class PtEbulicaoController extends AbstractController<PtEbulicao> {

    public PtEbulicaoController() {
        // Inform the Abstract parent controller of the concrete PtEbulicao?cap_first Entity
        super(PtEbulicao.class);
    }

}
