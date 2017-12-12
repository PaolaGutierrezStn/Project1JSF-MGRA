package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.Consumer;

public class ConsumerDAO  extends DAO<Consumer>{

    public ConsumerDAO() {
        super(new Consumer());
    }
    public Consumer getOneById(Consumer consumer) throws HibernateException {
        return super.getOneById(consumer.getIdConsumer()); 
    }
    public Consumer login (Consumer consumer){
        List<String> parameters= new ArrayList<String>();
        List<Object>values= new ArrayList<Object>();
        parameters.add("nameConsumer");
        parameters.add("password");
        values.add(consumer.getNameConsumer());
        values.add(consumer.getPassword());
        consumer = query("SELECT u FROM "
                +model.getClass().getName()
                +" u WHERE u.nameConsumer =:nameConsumer "
                +"AND u.password=:password",
                        parameters, values);
        return consumer;
    }
    
}