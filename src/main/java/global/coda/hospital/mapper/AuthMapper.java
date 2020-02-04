package global.coda.hospital.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Select;

import global.coda.hospital.models.LoginDetails;


public interface AuthMapper {
	@Select("select fk_role_id from hospital_management_system.t_user where (user_name=#{userName} and password=#{password})")
	int authentication(LoginDetails user) throws SQLException,Exception;
}
