package global.coda.hospital.JPA;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, Integer> {  
	
}

