/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Module;
import utng.model.Teacher;

/**
 *
 * @author Orlando
 */
public class TeacherDAO extends DAO<Teacher> {
    public TeacherDAO() {
        super(new Teacher());
    }

    
    public Teacher getOneById(Teacher teacher) throws HibernateException {
        return super.getOneById(teacher.getIdTeacher()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
