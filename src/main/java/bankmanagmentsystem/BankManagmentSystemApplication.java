package bankmanagmentsystem;

import bankmanagmentsystem.controller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackageClasses = CustomerController.class) <--not required as of now

public class BankManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagmentSystemApplication.class, args);
	}

}
