package boundary_of_law.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import boundary_of_law.models.User;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView ("login","user",new User());
	}
	
}
