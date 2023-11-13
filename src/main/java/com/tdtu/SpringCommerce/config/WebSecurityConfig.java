package com.tdtu.SpringCommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//    private UserService userService;
//    @Autowired
//    public WebSecurityConfig(UserService userService){
//        this.userService=userService;
//    }
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.csrf().disable();
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login", "/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin(form-> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/home")
//                        .failureUrl("/login?error=true")
//                        .failureHandler(new SimpleUrlAuthenticationFailureHandler(){
//                            @Override
//                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                                System.out.println(exception.getMessage());
//                                super.onAuthenticationFailure(request, response, exception);
//                            }
//                        })
//                        .permitAll())
//                .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
    }


}