package ui.bean;

import entity.Users;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usersController")
@ViewScoped
public class UsersController extends AbstractController<Users> {

    @Inject
    private RolerController rolerCollectionController;
    @Inject
    private FuncionarioController funcionarioCollectionController;

    public UsersController() {
        // Inform the Abstract parent controller of the concrete Users?cap_first Entity
        super(Users.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Roler entities that are
     * retrieved from Users?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Roler page
     */
    public String navigateRolerCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Roler_items", this.getSelected().getRolerCollection());
        }
        return "/entity/roler/index";
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Users?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcionario page
     */
    public String navigateFuncionarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcionario_items", this.getSelected().getFuncionarioCollection());
        }
        return "/entity/funcionario/index";
    }

}
