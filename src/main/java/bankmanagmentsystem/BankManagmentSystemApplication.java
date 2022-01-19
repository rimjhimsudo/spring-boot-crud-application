package bankmanagmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackageClasses = CustomerController.class) <--not required as of now
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
//@EnableJpaRepositories("bankmanagmentsystem.repository.CustomerRepository")
public class BankManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagmentSystemApplication.class, args);
	}

}
