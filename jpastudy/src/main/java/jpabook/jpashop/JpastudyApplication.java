package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class JpastudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpastudyApplication.class, args);
    }

    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }

    // lazy 모두 null로 뜸
//    @Bean
//    Hibernate5Module hibernate5Module() {
//        return new Hibernate5Module();
//    }


    //강제로 지연 로딩 가능
//    @Bean
//    Hibernate5Module hibernate5Module() {
//        Hibernate5Module hibernate5Module = new Hibernate5Module();
//        //강제 지연 로딩 설정
//        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,
//                true);
//        return hibernate5Module;
//    }
    //하지만 entity 호출이므로 비추

}
