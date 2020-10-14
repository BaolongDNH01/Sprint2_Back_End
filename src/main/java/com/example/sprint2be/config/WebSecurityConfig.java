package com.example.sprint2be.config;

import com.example.sprint2be.model.Rank;
import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.constant.ERoleName;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.repository.RankRepository;
import com.example.sprint2be.repository.RoleRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.security.JwtEntryPoint;
import com.example.sprint2be.service.security.JwtFilter;
import com.example.sprint2be.service.user.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${app.admin.username}")
    private String adminUsername;

    @Value("${app.admin.password}")
    private String adminPassword;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RankRepository rankRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFilter authenticationFilter() {
        return new JwtFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    ApplicationRunner init(RoleRepository roleRepository, UserRepository userRepository) {
        System.out.println("Created !");
        return args -> {
            if (roleRepository.findAll().isEmpty()) {

                Role adminRole = new Role(ERoleName.ROLE_ADMIN);
                adminRole.setId(1);

                Role memberRole = new Role(ERoleName.ROLE_MEMBER);
                memberRole.setId(2);

                roleRepository.save(adminRole);
                roleRepository.save(memberRole);

                Set<Role> roles = new HashSet<>();
                roles.add(roleRepository.findByRoleName(ERoleName.ROLE_ADMIN).orElseThrow(
                    () -> new RuntimeException("Role doesn't exist")
                ));

                User admin = new User();
                Cart cart = new Cart();
                for (Role role: roles) {
                    System.out.println(role.getRoleName());
                }



                String[] ranks = {"Đồng", "Bạc", "Vàng", "Bạch kim", "Kim cương"};

                for (String s : ranks) {
                    Rank rank = new Rank();
                    rank.setName(s);
                    rankRepository.save(rank);
                }
                admin.setUsername(adminUsername);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setFullName("ADMIN");
                admin.setEmail("admin@gmail.com");
                admin.setAddress("Da Nang");
                admin.setPhone("0123456799");
                admin.setAvatar("https://firebasestorage.googleapis.com/v0/b/real-estate-d8b23.appspot.com/o/mWBlKu8IIggRNhyUutW8?alt=media&token=7f0c3569-e638-4160-bdb5-28cf4dfe22eb");
                admin.setIdCard("123456789012");
                admin.setRoles(roles);
                admin.setPoint(10000);

                admin.setRank(rankRepository.findById(4).orElse(null));
                admin.setEnabled("true");;
                admin.setCart(cart);

                userRepository.save(admin);

                Set<Role> rolesForMember = new HashSet<>();
                rolesForMember.add(roleRepository.findByRoleName(ERoleName.ROLE_MEMBER).orElseThrow(
                        () -> new RuntimeException("Role doesn't exist")
                ));

                // Thien: Create member account to test feature
                User member = new User();
                Cart cartForMember = new Cart();
                cartForMember.setShipCost(30000.0);
                cartForMember.setTotalPrice(0.0);

               

                member.setUsername("member");
                member.setPassword(passwordEncoder.encode("123123"));
                member.setFullName("MEMBER");
                member.setEmail("member@gmail.com");
                member.setAddress("Da Nang");
                member.setPhone("0123456799");
                member.setAvatar("https://firebasestorage.googleapis.com/v0/b/real-estate-d8b23.appspot.com/o/mWBlKu8IIggRNhyUutW8?alt=media&token=7f0c3569-e638-4160-bdb5-28cf4dfe22eb");
                member.setIdCard("123456789012");
                member.setRoles(rolesForMember);
                member.setRank(rankRepository.findById(4).orElse(null));
                member.setCart(cartForMember);
                member.setEnabled("true");
                member.setPoint(10);
                userRepository.save(member);
            }
        };
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .addFilterBefore(
                authenticationFilter(),
                UsernamePasswordAuthenticationFilter.class
            );
    }
}
