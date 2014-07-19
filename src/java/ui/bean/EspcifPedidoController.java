package ui.bean;

import entity.EspcifPedido;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "espcifPedidoController")
@ViewScoped
public class EspcifPedidoController extends AbstractController<EspcifPedido> {

    public EspcifPedidoController() {
        // Inform the Abstract parent controller of the concrete EspcifPedido?cap_first Entity
        super(EspcifPedido.class);
    }

}
