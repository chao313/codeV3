package demo.spring.boot.demospringboot.config;

import demo.spring.boot.demospringboot.framework.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()//通过authorizeRequests来开始请求权限分配
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")//匹配 /admin/** ; 用户只有在ADMIN角色的访问
                .antMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")//匹配 /user/** ; 用户在USER|ADMIN下的任意一个角色都能访问
                .anyRequest().permitAll()//其余的请求都需要认证(登陆)后执行
                .and()
                .formLogin()
                .loginPage("/login")//这个类似拦截/login请求
                .usernameParameter("userName").passwordParameter("password")//这个类似从post请求中获取userName和password -> 会传递给MyUserDetailService
        ;

    }

}

@Service
class MyUserDetailService implements UserDetailsService {

    /**
     * 这里的逻辑在登陆时会调用，验证是否正确->根据userName获取password , 比较是否和参数中的一致
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: 2020/2/1 这里就是获取User的操作
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        UserDetails userDetails = new User("root", "root", grantedAuthorities);
        return userDetails;
    }
}


@RestController
class MyUserDetailController {

    @GetMapping("/admin/index")
    public Response adminIndex() {
        return Response.OK();
    }

    @GetMapping("/user/index")
    public Response userIndex() {
        return Response.OK();
    }

    @PostMapping("/login")
    /**
     * 注意，这里的userName和password只是留着方便Swagger-ui去方面请求，实际已经在之前认证过程中验证过!!!
     */
    public Response indexIndex(String userName, String password) {
        return Response.OK();
    }

}

