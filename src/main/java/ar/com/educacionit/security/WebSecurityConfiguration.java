
package ar.com.educacionit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserService myUserService;
	
//	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.myUserService)
			.passwordEncoder(bcrypt);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(new String[]{"/","/home"}).permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated().and().csrf().disable().formLogin()//pero la home o el /
			.loginPage("/login").failureForwardUrl("/login?error=true")
			.defaultSuccessUrl("/home")
			.usernameParameter("username")
			.usernameParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").and().exceptionHandling()
			.accessDeniedPage("/access-denied");
		
		http.requiresChannel()
			.requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null )//sin eso no andaba en heroku !!
			.requiresSecure();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**","/assests/**");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
}