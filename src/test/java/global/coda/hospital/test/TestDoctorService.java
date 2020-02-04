//package global.coda.hospital.test;
//import static global.coda.hospital.test.TestConstants.*;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//
//import global.coda.hospital.mapper.DoctorMapper;
//import global.coda.hospital.models.DoctorDetails;
//public class TestDoctorService {
//		DoctorDetails doctor = new DoctorDetails();
//		private DoctorMapper doctorMapper;
//		public void DoctorService(DoctorMapper doctorMapper) {
//			this.doctorMapper = doctorMapper;
//		}
//		//DoctorService doctorService =new DoctorService(doctorMapper);
//		@Test
//		public void doctorReadTest() {
//			try
//			{
//			doctor=doctorMapper.getDoctorByIdMapper((DOCTOR_ID));
//			assertEquals(doctor.getUserName(),DOCTOR_USER_NAME);
//			}
//			catch(Exception error)
//			{
//				System.out.println(error.getMessage());
//			}
//			
//		}
//		
//		@Test
//		public void doctorAddTest() {
//			try
//			{
//			doctor.setUserName(DOCTOR_USER_NAME);
//			assertEquals(BOOLEAN,doctorMapper.createUserRecordMapper((doctor)));
//			}
//			catch(Exception error)
//			{
//				System.out.println(error.getMessage());
//			}
//			
//		}
//		@Test
//		public void doctorUpdateTest() {
//			try
//			{
//			doctor.setUserName(DOCTOR_USER_NAME);
//			assertEquals(BOOLEAN,(doctorMapper.updateUserRecordMapper(doctor)));
//			}
//			catch(Exception error)
//			{
//				System.out.println(error.getMessage());
//			}
//		}
//
//		@Test
//		public void doctorDeleteTest() {
//			try
//			{
//			assertEquals(BOOLEAN,doctorMapper.deleteDoctorMapper((TEST_USER_ID)));
//			}
//			catch(Exception error)
//			{
//				System.out.println(error.getMessage());
//			}
//			
//		}
//	}
