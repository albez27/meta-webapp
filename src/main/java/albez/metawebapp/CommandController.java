package albez.metawebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommandController {
    @RequestMapping("robot")
    public String commandPage(){
        return "robotPage";
    }
}
