/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.TeacherDAO;
import utng.model.Teacher;

/**
 *
 * @author Orlando
 */
    @ManagedBean
@SessionScoped
public class TeacherBean implements Serializable {
    
    private List<Teacher> teachers;
    private Teacher teacher;
    public TeacherBean(){}

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher){
    this.teacher = teacher;
    }
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    
    public String list(){
        TeacherDAO dao = new TeacherDAO();
        try {
            teachers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Teachers";
    }
    
    public String delete(){
         TeacherDAO dao = new TeacherDAO();
        try {
            dao.delete(teacher);
            teachers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        teacher= new Teacher();
        return "Start";
    }
    
    public String save(){
        TeacherDAO dao = new TeacherDAO();
        try {
            if(teacher.getIdTeacher()!= 0){
                dao.update(teacher);
            }else {
                dao.insert(teacher);
            }
            teachers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Teacher teacher){
        this.teacher=teacher;
        return "Edit";
    }
        
}
    
    
    
