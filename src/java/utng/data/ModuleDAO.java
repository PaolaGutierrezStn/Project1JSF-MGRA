package utng.data;

import org.hibernate.HibernateException;
import utng.data.DAO;
import utng.model.Module;


public class ModuleDAO extends DAO<Module> {

    public ModuleDAO() {
        super(new Module());
    }

    
    public Module getOneById(Module module) throws HibernateException {
        return super.getOneById(module.getIdModule()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
