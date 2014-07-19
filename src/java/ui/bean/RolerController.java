package ui.bean;

import entity.Roler;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rolerController")
@ViewScoped
public class RolerController extends AbstractController<Roler> {

    @Inject
    private UsersController usersCollectionController;
    @Inject
    private FuncionarioController funcionarioCollectionController;

    public RolerController() {
        // Inform the Abstract parent controller of the concrete Roler?cap_first Entity
        super(Roler.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Users entities that are
     * retrieved from Roler?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Users page
     */
    public String navigateUsersCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Users_items", this.getSelected().getUsersCollection());
        }
        return "/entity/users/index";
    }

    /**
     * Sets the "items" attribute with a collection of Funcionario entities that
     * are retrieved from Roler?cap_first and returns the navigation outcome.
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
