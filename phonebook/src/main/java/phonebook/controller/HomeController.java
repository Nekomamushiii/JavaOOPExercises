package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    public String page = "";
    @GetMapping("home")
    public ModelAndView home(ModelAndView modelAndView){
        this.page="Hoomeee";
        modelAndView.setViewName("home.html");
        modelAndView.addObject("page",page);
        modelAndView.addObject("bestStudent","Тэмүгэ");
        return modelAndView;
    }
}
