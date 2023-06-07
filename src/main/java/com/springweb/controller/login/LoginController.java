package com.springweb.controller.login;

import java.sql.Date;



import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mysql.cj.util.StringUtils;
import com.springweb.common.SendEmailUtil;
import com.springweb.common.StaticVariable;
import com.springweb.entity.Role;
import com.springweb.entity.User;
import com.springweb.entity.UserRole;
import com.springweb.request.login.OtpNewPassWord;
import com.springweb.request.login.SaveUserRequest;
import com.springweb.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	User user;
	String email = "";
	String error = null;

	@RequestMapping(value = "/login")
	public String welcome(Model model) {
		return "login/login";
	}

	@RequestMapping(value = "/logoutSuccessful")
	public String logout(Model model) {
		SecurityContextHolder.clearContext();
		return "redirect:homepage";
	}

	@RequestMapping(value = "/recover", method = RequestMethod.GET)
	public String recover() {
		return "login/recover";

	}

	@RequestMapping(value = "/confirmuser", method = RequestMethod.GET)
	public String Comfimuser(@ModelAttribute(name = "oNewPassWord") OtpNewPassWord oNewPassWord, Model model) {

		email = oNewPassWord.getEmail();

		try {
			user = userService.findUserByEmail(email);

			if (Objects.nonNull(user)) {
				model.addAttribute("user", user);

			} else {
				model.addAttribute("error", "Khong tim thay tai khoan");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "login/confirmuser";

	}

	@RequestMapping(value = "/loginoption", method = RequestMethod.GET)
	public String OptionLogin(Model model, @RequestParam(name = "name") String name) {
	
		model.addAttribute("name", name);
		
		return "login/loginoption";
	}

	@RequestMapping(value = "/recover", method = RequestMethod.POST)
	public String SendMailOTP(@ModelAttribute(name = "oNewPassWord") OtpNewPassWord oNewPassWord, HttpSession session) {

		String subject = "Reset Pass From Vá»› store !";

		Random r = new Random();
		int otp = r.nextInt((999999 - 100000) + 1) + 100000;

		session.setAttribute("otp", String.valueOf(otp));

		session.setMaxInactiveInterval(60);
		String content = "Hello \r\n" + "Ä‘Ã¢y lÃ  mÃ£ otp cá»§a báº¡n : " + otp + "\r\n" + "Thanks you!";

		try {
			SendEmailUtil.sendEmail(StaticVariable.HOST, StaticVariable.POST, StaticVariable.MAIL_SEVER,
					StaticVariable.PASSWORD, email, subject, content);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "login/otpconfirm";
	}

	@RequestMapping(value = "/otpconfirm", method = RequestMethod.POST)
	public String OTPConfirm(HttpSession session, @ModelAttribute(name = "oNewPassWord") OtpNewPassWord oNewPassWord,
			Model model) {

		String fullOtp = oNewPassWord.getOtp1() + oNewPassWord.getOtp2() + oNewPassWord.getOtp3()
				+ oNewPassWord.getOtp4() + oNewPassWord.getOtp5() + oNewPassWord.getOtp6();

		String sessionOtp = (String) session.getAttribute("otp");

		if (fullOtp.equals(sessionOtp)) {
			model.addAttribute("mail", email);

			return "login/changenewpass";
		} else {
			model.addAttribute("otpstatus", "MÃ£ xÃ¡c thá»±c khÃ´ng Ä‘Ãºng hoáº·c Ä‘Ã£ háº¿t háº¡n");

			return "login/otpconfirm";
		}
	}

	@RequestMapping(value = "/newpass", method = RequestMethod.POST)
	public String newPass(@ModelAttribute(name = "oNewPassWord") OtpNewPassWord oNewPassWord, Model model) {

		if (oNewPassWord.getUserPass().equals(oNewPassWord.getUserPass1())) {

			try {

				user.setPassWord(passwordEncoder.encode(oNewPassWord.getUserPass()));
				userService.saveUser(user);

			} catch (Exception e) {
				e.printStackTrace();

			}

			return "login/login";
		} else {
			model.addAttribute("error", "Máº­t kháº©u khÃ´ng khá»›p");
			return "login/changenewpass";

		}
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String rigist(Model model) {

		if (!StringUtils.isNullOrEmpty(error)) {
			model.addAttribute("error", error);
		}

		System.out.println("hahahaa");
		return "login/regist";
	}
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String rigistAccount(@ModelAttribute("uRequest") SaveUserRequest uRequest, Model model)
			throws SQLException, JsonMappingException, JsonProcessingException {
		User user = new User();

		UserRole userRole = new UserRole();

		String mail = uRequest.getMail();

		Set<UserRole> rloes = new HashSet<>();

		if (!validate(mail)) {
			error = "Email khÃ´ng Ä‘Ãºng Ä‘á»‹nh dáº¡ng";

			return "login/regist";
		}

		if (uRequest.getPassword().equals(uRequest.getRepassword())) {

			user.setUserName(uRequest.getUsername());
			user.setFullName(uRequest.getFullname());
			user.setEmail(uRequest.getMail());
			user.setPassWord(passwordEncoder.encode(uRequest.getPassword()));
			user.setCreateBy(uRequest.getFullname());
			user.setCreateDate(new Date(System.currentTimeMillis()));
			user.setModifyDate(new Date(System.currentTimeMillis()));
			user.setRoleId(1);

			Role role = new Role();
			role = userService.findRoleByRoleName("ROLE_USER");

			userRole.setRole(role);
			userRole.setUser(user);
			userRole.setCreateDate(new Date(System.currentTimeMillis()));
			userRole.setModifyDate(new Date(System.currentTimeMillis()));
			rloes.add(userRole);

			user.setRloes(rloes);

			userService.saveUser(user);

			return "redirect:login";

		} else {
			error = "Nháº­p láº¡i máº­t kháº©u khÃ´ng Ä‘Ãºng";
			model.addAttribute("error", error);
			return "login/regist";

		}
	}

	private boolean validate(String emailStr) {
		Pattern pattern = Pattern.compile("^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(emailStr);
		boolean matchFound = matcher.find();
		return matchFound;
	}

}
