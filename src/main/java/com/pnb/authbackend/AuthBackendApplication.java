package com.pnb.authbackend;

import com.pnb.authbackend.models.ApplicationUser;
import com.pnb.authbackend.models.Role;
import com.pnb.authbackend.repositories.RoleRepository;
import com.pnb.authbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AuthBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthBackendApplication.class, args);
	}


	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder){
		return args -> {
			if(!roleRepository.findAll().isEmpty()) return;
			List<Role> roles = Arrays.asList(Role.builder().authority("USER").build(),Role.builder().authority("ADMIN").build());
			roleRepository.saveAll(roles);
			ApplicationUser applicationUser = ApplicationUser.builder().userName("Blaise").password(encoder.encode("admin")).authorities(roleRepository.findAll().stream().filter(r -> r.getAuthority().equals("ADMIN")).collect(Collectors.toSet())).build();
			userRepository.save(applicationUser);
			System.out.println("applicationUser = " + applicationUser);
		};
	}

}
