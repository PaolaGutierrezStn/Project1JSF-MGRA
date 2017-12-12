/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Orlando
 */

@Entity
@Table(name="teacher")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_teacher")
    private Long idTeacher;
    @Column(name="name", length=100)
    private String name;
    
    @Column(name="address", length=100)
    private String address;
    
    @Column(name="email", length=100)
    private String email;
    
    @Column(name="telephone", length=100)
    private String telephone;
    
    public Teacher(Long idTeacher, String name, String address, String email, String telephone){
        super();
        this.idTeacher=idTeacher;
        this.name=name;
        this.address=address;
        this.email=email;
        this.telephone=telephone;
    
}
    
     public Teacher() {
        this(0L,"","","","");
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}