package global.coda.hospital.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hospital.exceptions.BusinessException;
import global.coda.hospital.exceptions.SystemException;
import global.coda.hospital.models.CustomResponse;
import global.coda.hospital.models.LoginDetails;
import global.coda.hospital.models.UserDetails;
import global.coda.hospital.services.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class AuthController {
	@Autowired
	private UserService userService;
	/**
	 * Instantiates a new doctor controller.
	 * @param doctorService the doctor service
	 */
	public AuthController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/auth")
	public CustomResponse<Integer> updateDoctor(@RequestBody LoginDetails user,@RequestAttribute("requestId") String requestId,HttpServletRequest httpServletRequest) throws BusinessException, SystemException {
		System.out.println(user.toString());
		int role = userService.authUserService(user);
		System.out.println(role);
		CustomResponse<Integer> response= new CustomResponse<Integer>();
		response.setObject(role);
		response.setStatus("OK");
		response.setSuccess(true);
		response.setRequestId((UUID) httpServletRequest.getAttribute("requestId"));
		return response;
	}
}
