package com.cybersoft.cozastore_java21.config;

import com.cybersoft.cozastore_java21.filter.JwtFilter;
import com.cybersoft.cozastore_java21.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private CustomAuthenProvider authenticationProvider;

    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)

                .authenticationProvider(authenticationProvider)
                .build();

    }

    /**
     * /admin/save: admin hoặc save
     * /admin/delete: DELETE
     *
     * */

//    đầy là filter dùng để custom rule liên quan tới link hoặc
//    cấu hình của security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        tắt cấu hình liên qua tới tấn công csrf
        return http.csrf().disable()
// khai báo không sử dụng session trong project
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                quy định cac rule liên quan tới tấn công tới chứng thực cho link chưa được gọi
                .authorizeHttpRequests()
//                Java8,Java11: antMatchers
//                java17~: requestAntMachers
//                permitAll: cho phép vào luôn không cần chứng thực
                    .antMatchers("/signin","/signup","/demo/**").permitAll()
//                hasRole: phải có quyền admin mới vào được
                    .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
