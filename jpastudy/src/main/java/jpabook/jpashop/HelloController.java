package jpabook.jpashop;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
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

//    @GetMapping
//    public Resource<User> retreveUser(@PathVariable int id){
//        User user = service.findOne(id);
//
//        //HATEOAS
//        Resource<User> resource = new Resource<>(user);
//        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//        resource.add(linkTo.withRel("all-users"));
//
//        return resource;
//
//    }


}
