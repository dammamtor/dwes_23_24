package com.velazquez.entregablespring_dmt;

import static org.springframework.security.config.Customizer.withDefaults;

import com.velazquez.entregablespring_dmt.services.JPAUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * CLASE DONDE ESTABLECEREMOS LA CONFIGURACION DE
 * AUTENTIFICACION - CÓMO ACCEDO
 * AUTORIZACION - A QUÉ PUEDO ACCEDER
 * MÉTODO DE ENCRIPTACIÓN DE LAS CONTRASEÑAS
 */

/*
 * CLASE DONDE ESTABLECEREMOS LA CONFIGURACION DE
 * AUTENTIFICACION - CÓMO ACCEDO
 * AUTORIZACION - A QUÉ PUEDO ACCEDER
 * MÉTODO DE ENCRIPTACIÓN DE LAS CONTRASEÑAS
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  /* Obtengo una refencia al SINGLENTON del userDetailsService	 *
   */
  @Autowired
  JPAUserDetailsService userDetailsService;

  @Bean
  public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);
    authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(getPasswordEncoder());
    return authenticationManagerBuilder.build();
  }

  /*
   * MÉTODO PARA ESTABLECER AUTORIZACION - A QUÉ PUEDO ACCEDER
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    /* URL con información sobre ANT MATCHERS
     * https://www.baeldung.com/spring-security-expressions */
    http.authorizeHttpRequests(
                    authz ->
                            authz
                                    .requestMatchers("/", "/img/*")
                                    .permitAll()
                                    .requestMatchers("/grados/*", "/usuarios/*")
                                    .hasRole("ADMIN")
                                    .requestMatchers("/profesores/*")
                                    .hasRole("USER")
                                    .requestMatchers("/register")
                                    .anonymous())
            .formLogin(withDefaults())
            .httpBasic(withDefaults());
    return http.build();
  }

  /*
   * ESTABLECEMOS EL PASSWORD ENCODER. FUERZA 15 (de 4 a 31)
   */
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder(15);
  }
}
