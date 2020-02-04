package global.coda.hospital.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import global.coda.hospital.exceptions.BusinessException;
import global.coda.hospital.exceptions.SystemException;
import global.coda.hospital.mapper.AuthMapper;
import global.coda.hospital.models.LoginDetails;
@Service
public class UserService {
	@Autowired
	private AuthMapper authMapper;
	/**
	 * Instantiates a new doctor service.
	 * @param doctorMapper the doctor mapper
	 */
	public UserService(AuthMapper authMapper) {
		this.authMapper = authMapper;
	}
	public int authUserService(LoginDetails user) throws BusinessException, SystemException {
		try {
			System.out.println(user.toString());
			int role = authMapper.authentication(user);
//			System.out.println(role);
			return role;
		} catch (SQLException error) {
			System.out.println(error.getMessage());
			throw new SystemException(error.getMessage());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			throw new SystemException(exception.getMessage());
		}
	
	}
}
