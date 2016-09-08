package fi.softala.aani;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainCtrl {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

}