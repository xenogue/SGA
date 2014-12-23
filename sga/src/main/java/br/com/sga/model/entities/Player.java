package br.com.sga.model.entities;

/**
 *
 * @author rios
 */
import java.io.Serializable;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Player implements Serializable{
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    private String name;
    private int age;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    @Override
    public int hashCode() {
        return getId();
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Player){
            Player player = (Player) obj;
            return player.getId() == getId();
        }
 
        return false;
    }
}