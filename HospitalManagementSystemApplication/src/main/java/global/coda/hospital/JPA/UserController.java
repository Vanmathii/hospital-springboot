package global.coda.hospital.JPA;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;  
import java.util.List;  
import java.util.Optional;  
@RestController  
@RequestMapping("/userdetails")
public class UserController {  
    @Autowired  
    private UserServiceJPA userService;   
    @RequestMapping("/all")  
    public List<UserRecord> getAllUser(){  
        return userService.getAllUsers();  
    }     
    @PostMapping(value="/add")  
    public void addUser(@RequestBody UserRecord userRecord){  
        userService.addUser(userRecord);  
    }  
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)  
    public Optional<UserRecord> getUser(@PathVariable Integer id){  
        return userService.getUser(id);  
    }  
}  
