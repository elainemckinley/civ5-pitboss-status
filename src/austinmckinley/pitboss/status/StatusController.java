package austinmckinley.pitboss.status;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/")
public class StatusController {

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("test", "Hello World!");
		return "status-index";
	}
	
	@RequestMapping(value="/logging-input", method = RequestMethod.POST)
	public String updateLogData(Model model) {
		model.addAttribute("test", "Hello World!");
		return "status-index";
	}
}
