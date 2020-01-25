package global.coda.hospital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The Class HospitalManagementSystemApplication.
 */
@SpringBootApplication
@MapperScan("global.coda.hospital.mapper")
public class HospitalManagementSystemApplication {
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
	}
}
