package controller;

import com.aubrun.eric.projet7.springmvc.consumer.BookConsumer;
import com.aubrun.eric.projet7.springmvc.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class HelloController {

    private final BookConsumer bookConsumer;

    public HelloController(BookConsumer bookConsumer) {
        this.bookConsumer = bookConsumer;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap) {

        // add attribute to load modelMap
        modelMap.addAttribute("message",
                "Hello World and Welcome to Spring MVC!");
        Books books = bookConsumer.findAllBooks().getBody();
        // return the name of the file to be loaded "hello_world.jsp"
        return "hello_world";
    }
}