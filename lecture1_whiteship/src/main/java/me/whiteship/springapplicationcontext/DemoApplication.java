package me.whiteship.springapplicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

//@SpringBootApplication : Bean 설정을 알아서 해줌 -spring boot-
public class DemoApplication {

    public static void main(String[] args) {
        //`ApplicationContext.class`를 빈설정 파일로 설정하겠다~
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }
}
