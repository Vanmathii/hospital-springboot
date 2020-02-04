package global.coda.hospital.JPA;
import javax.persistence.Entity;  
import javax.persistence.Id;
@Entity 
public class UserRecord {  
    @Id  
    int id;  
    String name;  
    String email;  
    public UserRecord(){}  
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
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
}  