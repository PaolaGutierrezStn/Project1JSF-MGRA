package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utng.data.RoleDAO;
import utng.data.ConsumerDAO;
import utng.model.Role;
import utng.model.Consumer;

@ManagedBean(name="consumerBean") 
@SessionScoped
public class ConsumerBean implements Serializable{
    private List<Consumer> consumers;
    private Consumer consumer;
    private List<Role> roles;
    public ConsumerBean(){
        consumer = new Consumer();
        consumer.setRole(new Role());
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    
    
     public String list(){
        ConsumerDAO dao = new ConsumerDAO();
        try {
            consumers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Consumers";
    }
    
    public String delete(){
         ConsumerDAO dao = new ConsumerDAO();
        try {
            dao.delete(consumer);
            consumers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        consumer= new Consumer();
        consumer.setRole(new Role());
        try {
            roles= new RoleDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        ConsumerDAO dao = new ConsumerDAO();
        try {
            if(consumer.getIdConsumer()!= 0){
                dao.update(consumer);
            }else {
                dao.insert(consumer);
            }
            consumers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Consumer consumer){
        this.consumer=consumer;
        try {
            roles = new RoleDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
    public String login(){
        consumer = new ConsumerDAO().login(this.consumer);
        if(consumer != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("consumer",consumer);
            return "Right";
        }else {
            consumer = new Consumer();
            return "Incorrect";
        }
    }
     public String logout(){
        if(consumer!=null){
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .clear();
        }
        consumer= new Consumer();
        return "Logout";
    }
    
    
}
