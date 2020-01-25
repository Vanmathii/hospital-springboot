package global.coda.hospital.mapper;

import global.coda.hospital.models.DoctorDetails;
import global.coda.hospital.models.DoctorSpecificPatients;
import global.coda.hospital.models.PatientDetails;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The Interface DoctorMapper.
 */
@Mapper
public interface DoctorMapper {
	/**
	 * Gets the all doctors mapper.
	 * @return the all doctors mapper
	 */
	@Select("select * from hospital_management_system.t_user t join hospital_management_system.t_doctor p on t.pk_user_id=p.fk_user_id_doctor where (fk_role_id=3 and is_active=1)")
	List<DoctorDetails> getAllDoctorsMapper() throws SQLException,Exception;
	/**
	 * Gets the doctor by id mapper.
	 * @param userId the user id
	 * @return the doctor by id mapper
	 */
	@Select("select * from hospital_management_system.t_user t join hospital_management_system.t_doctor p on t.pk_user_id=p.fk_user_id_doctor where (pk_user_id=#{userId} and is_active=1)")
	DoctorDetails getDoctorByIdMapper(int userId) throws SQLException,Exception;
	/**
	 * Update user record mapper.
	 * @param doctor the doctor
	 * @return the int
	 */
	@Update("UPDATE hospital_management_system.t_user SET first_name=#{firstName},last_name=#{lastName}, user_age=#{userAge},user_mobile_number=#{userMobileNumber}, user_addressline1=#{userAddressline1},user_addressline2=#{userAddressline2}, user_addressline3= #{userAddressline3}, user_name =#{userName}, password=#{password} WHERE pk_user_id = #{pkUserId}")
	int updateUserRecordMapper(DoctorDetails doctor)throws SQLException,Exception;
	/**
	 * Update doctor record mapper.
	 * @param doctor the doctor
	 * @return the int
	 */
	@Update("UPDATE hospital_management_system.t_doctor SET specialization=#{specialization} WHERE fk_user_id_doctor = #{pkUserId}")
	int updateDoctorRecordMapper(DoctorDetails doctor)throws SQLException,Exception;
	/**
	 * Delete user mapper.
	 * @param id the id
	 * @return the int
	 */
	@Delete("UPDATE hospital_management_system.t_user SET is_active = 0 WHERE (pk_user_id = #{id})")
	int deleteUserMapper(int id)throws SQLException,Exception;
	/**
	 * Delete doctor mapper.
	 * @param id the id
	 * @return the int
	 */
	@Delete("UPDATE hospital_management_system.t_doctor SET is_active_doctor = 0 WHERE (fk_user_id_doctor = #{id})")
	int deleteDoctorMapper(int id)throws SQLException,Exception;
	/**
	 * Creates the user record mapper.
	 * @param doctor the doctor
	 * @return the int
	 */
	@Insert("INSERT INTO hospital_management_system.t_user (fk_role_id,first_name,last_name,user_age,user_mobile_number,user_addressline1,user_addressline2,user_addressline3,user_name,password, is_active) VALUES(#{fkRoleId},#{firstName},#{lastName},#{userAge},#{userMobileNumber},#{userAddressline1},#{userAddressline2},#{userAddressline3},#{userName},#{password}, 1)")
	@Options(useGeneratedKeys = true, keyProperty = "pkUserId", keyColumn = "pk_user_id")
	int createUserRecordMapper(DoctorDetails doctor)throws SQLException,Exception;
	/**
	 * Creates the doctor record mapper.
	 * @param doctor the doctor
	 * @return the int
	 */
	@Insert("INSERT INTO  hospital_management_system.t_doctor (fk_user_id_doctor,specialization, is_active_doctor) VALUES (#{pkUserId},#{specialization},1)")
	int createDoctorRecordMapper(DoctorDetails doctor)throws SQLException,Exception;
	/**
	 * Select patients.
	 * @param userId the user id
	 * @return the list
	 */
	@Select("select pk_user_id,first_name,last_name,user_age,user_mobile_number,user_addressline1,user_addressline2,user_addressline3,patient_disease,patient_blood_group from hospital_management_system.t_doctor t inner join hospital_management_system.t_patient_doctor_mapping p on t.fk_user_id_doctor=p.fk_user_id_doctor_mappings inner join hospital_management_system.t_patient k on p.fk_user_id_patient_mapping=k.fk_user_id_patient inner join hospital_management_system.t_user u on k.fk_user_id_patient=u.pk_user_id where (fk_user_id_doctor = #{userId} and is_active=1)")
	@Results(value = { @Result(property = "userId", column = "pk_user_id"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name"), @Result(property = "userAge", column = "user_age"),
			@Result(property = "userMobileNumber", column = "user_mobile_number"),
			@Result(property = "userAddressline1", column = "user_addressline1"),
			@Result(property = "userAddressline2", column = "user_addressline2"),
			@Result(property = "userAddressline3", column = "user_addressline3"),
			@Result(property = "patientDisease", column = "patient_disease"),
			@Result(property = "patientBloodgroup", column = "patient_blood_group") })
	List<PatientDetails> selectPatients(int userId)throws SQLException,Exception;
	/**
	 * Gets the all patientsof doctor mapper.
	 * @param userId the user id
	 * @return the all patientsof doctor mapper
	 */
	@Select({
			"<script>SELECT first_name,specialization,pk_user_id FROM hospital_management_system.t_user t inner join hospital_management_system.t_doctor d on d.fk_user_id_doctor=t.pk_user_id <if test='userId!=0'>where fk_user_id_doctor=#{userId}</if></script>" })
	@Results(value = { @Result(property = "userId", column = "pk_user_id"),
			@Result(property = "name", column = "first_name"),
			@Result(property = "specialization", column = "specialization"),
			@Result(property = "patientList", column = "pk_user_id", javaType = List.class, many = @Many(select = "selectPatients")) })
	List<DoctorSpecificPatients> getAllPatientsofDoctorMapper(int userId)throws SQLException,Exception;
}
