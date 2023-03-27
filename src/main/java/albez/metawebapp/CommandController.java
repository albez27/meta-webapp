package albez.metawebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class CommandController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String commandPage(){
        return "robotPage";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCommand(@RequestParam HashMap<String, String> formData, Model model){
        HashMap<String, String> dataMapFromForm = setMap(formData);
        System.out.println(dataMapFromForm);
        model.addAttribute("data", dataMapFromForm);
        return "robotPage";
    }
    public HashMap<String, String> setMap(HashMap<String, String> formData){
        String helpKey = "";
        List<String> keys = Arrays.asList("fltType", "oldAtr", "newAtr", "tomcat", "block", "reverse",
                "chainy", "needCheck", "needArray", "needEdit");
        HashMap<String, String> mapWithKeys = new HashMap<>();
        for(String key : keys){
            mapWithKeys.put(key, "");
        }
        for(Map.Entry<String, String> map : mapWithKeys.entrySet()){
            helpKey = map.getKey();
            for(Map.Entry<String, String> mapData : formData.entrySet()){
                if(helpKey.equals(mapData.getKey())){
                    map.setValue(mapData.getValue());
                }
            }
        }
        return mapWithKeys;
    }
}
