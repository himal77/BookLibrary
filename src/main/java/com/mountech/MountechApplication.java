package com.mountech;

import com.mountech.domain.User;
import com.mountech.domain.security.Role;
import com.mountech.domain.security.UserRole;
import com.mountech.service.UserService;
import com.mountech.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Handler;

@SpringBootApplication
public class MountechApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(MountechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Adams");
		user.setUsername("j");
		user.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashMap<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		userRoles.add(new UserRole(user, role));

		userService.createUser(user, userRoles);

	}
}
