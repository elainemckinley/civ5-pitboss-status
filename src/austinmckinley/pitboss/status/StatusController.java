package austinmckinley.pitboss.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired StatusParser statusParser;

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("statusRecord", statusParser.getCurrentStatus().toString());
		return "status-index";
	}
}