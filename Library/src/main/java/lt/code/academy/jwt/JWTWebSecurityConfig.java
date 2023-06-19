package lt.code.academy.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static lt.code.academy.jwt.resource.PasswordEncoder.passwordEncoderBean;


@Configuration
public class JWTWebSecurityConfig {

    private JwtUnAuthorizedResponseAuthenticationEntryPoint jwtUnAuthorizedResponseAuthenticationEntryPoint;

    private UserDetailsService jwtInMemoryUserDetailsService;

    private JwtTokenAuthorizationOncePerRequestFilter jwtAuthenticationTokenFilter;

    @Value("${jwt.get.token.uri}")
    private String authenticationPath;

//    private void configure(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(jwtInMemoryUserDetailsService).passwordEncoder(passwordEncoderBean());
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
//        return authenticationConfiguration.getAuthenticationManager();
//    }

////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity security, AuthenticationConfiguration authenticationConfiguration, JwtTokenUtil jwtTokenUtil) throws Exception {
////        security
////                .csrf()
////                .disable()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeHttpRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .exceptionHandling()
////                .authenticationEntryPoint(jwtUnAuthorizedResponseAuthenticationEntryPoint)
////                .and()
////                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
////
////
////        return security.build();
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        return (web) -> web.ignoring()
                .requestMatchers(HttpMethod.POST, authenticationPath)
                .requestMatchers(HttpMethod.OPTIONS, "/**")
                .requestMatchers(HttpMethod.GET, "/");
    };
}

