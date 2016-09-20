package fi.softala.aani;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import List;

@Controller
public class MainCtrl {

	@RequestMapping("/")
    public String index(Model model) {
		ArrayList<String> innovations = new ArrayList<>();
		innovations.add("one");
		innovations.add("two");
		innovations.add("three");
		
		model.addAttribute("innovations", innovations);
		
        return "test";
    }

}