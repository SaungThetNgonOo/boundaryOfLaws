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
			List<User> users = systemUserRepo.getAll();

			map.addAttribute("user", users);// model
			List<User> systemusers = systemUserRepo.getAll();

			map.addAttribute("systemusers", systemusers);// model

			return "systemUserDisplay";// view
		}
		@RequestMapping("lawDisplay")
		public String displayLaw(ModelMap map) {
			List<User> users = systemUserRepo.getAll();

			map.addAttribute("users", users);// models
			return "lawdisplay";// view
		}
		//get are write to the appear form
//		@GetMapping("addauthor")
//		public ModelAndView addAuthor() {
//			return new ModelAndView("add_author","author",new Author());
//		}
		//post are wirte to get the data from form
//		@PostMapping("addauthor")
//		public String addAuthor(@ModelAttribute("author")@Validated Author author,BindingResult bResult,ModelMap map) {
//			if(bResult.hasErrors()) {
//				return "add_author";
//			}
//			int rs=authorRepo.add(author);
//			//repo adding fail due to Sql error or connection timeout 
//			if(rs==0) {
//				map.addAttribute("error_msg","Database Error");
//				return "add_author";
//			}
//			return "redirect:/authors";
//		}
//		
//		@GetMapping("editauthor/{id}")
//		public ModelAndView editAuthor(@PathVariable int id ) {
//			Author author=authorRepo.getById(id);//get old author from repo
//			return new ModelAndView("edit_author","author",author);
//		}
//		@PostMapping("editauthor")
//		public String editAuthor(@ModelAttribute("author")@Validated Author author,BindingResult bResult,ModelMap map) {
//			if(bResult.hasErrors()) {
//				return "edit_author";
//			}
//			int rs=authorRepo.edit(author);
//			//repo updating fail due to Sql error or connection timeout 
//			if(rs==0) {
//				map.addAttribute("error_msg","In Updating, Database something wrong.");
//				return "edit_author";
//			}
//			else {
//				return "redirect:/authors";
//			}
//		}
//		
//		@GetMapping("deleteauthor/{id}")
//		public String deleteAuthor(@PathVariable int id ) {
//			authorRepo.delete(id);//get old author from repo
//			return "redirect:/authors";
//		}
}

			map.addAttribute("systemusers", systemusers);// model
			return "lawdisplay";// view
		}
}
