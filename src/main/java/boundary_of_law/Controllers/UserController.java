package boundary_of_law.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import boundary_of_law.models.User;
import boundary_of_law.persistance.SystemUserRepo;

@Controller
public class UserController {
	@Autowired
	SystemUserRepo systemUserRepo;
	
	// displayBookServlet
		@RequestMapping("systemusers")
		public String displayAll(ModelMap map) {
			List<User> systemusers = systemUserRepo.getAll();

			map.addAttribute("systemusers", systemusers);// model
			return "systemUserDisplay";// view
		}
		@RequestMapping("lawDisplay")
		public String displayLaw(ModelMap map) {
			List<User> systemusers = systemUserRepo.getAll();

			map.addAttribute("systemusers", systemusers);// model
			return "lawdisplay";// view
		}
}