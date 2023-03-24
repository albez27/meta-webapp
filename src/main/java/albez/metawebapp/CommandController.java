package albez.metawebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommandController {
    @RequestMapping(value = "/robot", method = RequestMethod.GET)
    public String commandPage(){
        return "robotPage";
    }

}
