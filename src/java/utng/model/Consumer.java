package utng.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="consumer")
public class Consumer implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_consumer")
    private Long idConsumer;
    @Column(name="name_consumer", length=10)
    private String nameConsumer;
    @Column(length=40)
    private String password;
    @ManyToOne()
    @JoinColumn(name="id_role")
    private Role role;

    public Consumer(Long idConsumer, String nameConsumer, String password, Role role) {
        super();
        this.idConsumer = idConsumer;
        this.nameConsumer = nameConsumer;
        this.password = password;
        this.role = role;
    }

    
    public Consumer() {
        this.idConsumer=0L;
    }

    public Long getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(Long idConsumer) {
        this.idConsumer = idConsumer;
    }

    public String getNameConsumer() {
        return nameConsumer;
    }

    public void setNameConsumer(String nameConsumer) {
        this.nameConsumer = nameConsumer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
