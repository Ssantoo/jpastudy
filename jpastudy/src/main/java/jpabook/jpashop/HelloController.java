package jpabook.jpashop;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Locale;

@Controller
@AllArgsConstructor
public class HelloController {

    private final MessageSource messageSource;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";  //화면 이름
    }

    @GetMapping("/test")
    public String hello(@RequestHeader(name="Accept-Language", required=false) Locale locale){
        return messageSource.getMessage("greeting.message",null,locale);
    }

}
