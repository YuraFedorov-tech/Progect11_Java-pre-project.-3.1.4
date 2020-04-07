package ru.yura.web.app;
/*
 *
 *@Data 07.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import java.util.List;


@ComponentScan(basePackages = "ru")
//@EnableJpaRepositories(basePackages = "ru")
//@EnableRetry
@EnableCaching
//@EnableHystrix
@EntityScan(basePackages = "ru.yura")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        UserService userService = ctx.getBean(UserService.class);
        //  UserControllerOld userControllerOld = ctx.getBean(UserControllerOld.class);

        System.out.println("skjdhk;ajsfc");
        User user = userService.findModelByNames("2@2.ru");
        System.out.println(user.getEmail() + user.getId());

        List<User> users = userService.findAll();
        System.out.println(users);
        User userDelete = new User().setId(620L).setFirstName("555555555555");
        User userDelete2 = userService.delete(userDelete);
        System.out.println("userDelete2=" + userDelete2);
//        users = userService.findAll();
//        System.out.println(users);
//        String f=  userControllerOld.getAdminPanel(new ModelMap());


    }

}
