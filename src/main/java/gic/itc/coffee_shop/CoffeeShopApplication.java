package gic.itc.coffee_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// @ComponentScan({"gic.itc.coffee_shop.Controllers","gic.itc.coffee_shop.Services"})
// @EntityScan("gic.itc.coffee_shop.Entity")
// @EnableJpaRepositories("gic.itc.coffee_shop.Repository")
// @EnableAutoConfiguration
@SpringBootApplication
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}
	// @Bean
	// public BCryptPasswordEncoder bCryptPasswordEncoder() {
	// 	return new BCryptPasswordEncoder(); 
	// }

}
