package bankmanagmentsystem.webSecurity;

/*import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
uncomment this to add default web security
 */
/*
//@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //set here configuraton we want for our auth object
        auth.inMemoryAuthentication()
                .withUser("Rimjhim")
                .password("Vaish") //you cant save password as clear text so you need to hash it
                .roles("USER");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //deprecated
    }
}*/
public class WebSecurity{

}
