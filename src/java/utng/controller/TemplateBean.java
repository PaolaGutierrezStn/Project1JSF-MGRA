
package utng.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.model.Consumer;


@ManagedBean
@SessionScoped
public class TemplateBean implements Serializable{
    public void checkLogin(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Consumer consumer = (Consumer)context.getExternalContext().getSessionMap().get("consumer");
            if(consumer == null){
                context.getExternalContext().redirect("login.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
