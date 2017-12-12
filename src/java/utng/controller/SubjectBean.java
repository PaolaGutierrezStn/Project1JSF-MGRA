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
import utng.data.SubjectDAO;
import utng.data.TeacherDAO;
import utng.model.Subject;
import utng.model.Teacher;

/**
 *
 * @author Orlando
 */

@ManagedBean 
@SessionScoped
public class SubjectBean implements Serializable {
    private List<Subject> subjects;
    private Subject subject;
    private List<Teacher> teachers;
    public SubjectBean(){
        subject = new Subject();
        subject.setTeacher(new Teacher());
    
}

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

public String list(){
        SubjectDAO dao = new SubjectDAO();
        try {
            subjects=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Subjects";
    }
    
    public String delete(){
         SubjectDAO dao = new SubjectDAO();
        try {
            dao.delete(subject);
            subjects=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        subject= new Subject();
        subject.setTeacher(new Teacher());
        try {
            teachers= new TeacherDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        SubjectDAO dao = new SubjectDAO();
        try {
            if(subject.getIdSubject()!= 0){
                dao.update(subject);
            }else {
                dao.insert(subject);
            }
            subjects=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Subject subject){
        this.subject=subject;
        try {
            teachers = new TeacherDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}