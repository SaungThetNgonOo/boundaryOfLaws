package boundary_of_law.Controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import boundary_of_law.models.CaseType;
import boundary_of_law.models.Lawer;
import boundary_of_law.persistance.CaseTypeRepository;
import boundary_of_law.persistance.LawerRepository;

@Controller
public class LawerController {

    @Autowired
    CaseTypeRepository caseTypeRepo;
    @Autowired
    LawerRepository lawerRepo;

    @GetMapping("/")
    public String register(ModelMap map) {
        List<CaseType> caseTypes = caseTypeRepo.getAll();
        map.addAttribute("case_types", caseTypes);
        return "lawers/register";
    }

    @PostMapping("/")
    public String addLawer( ModelMap map, 
    		 @RequestParam(value="name")String name,
    		 @RequestParam(value="email")String email,
    		 @RequestParam(value="password")String password,
    		 @RequestParam(value="NRC")String NRC,
    		 @RequestParam(value="phone")String phone,
    		 @RequestParam(value="gender")String gender,
    		 @RequestParam(value="current_state")String current_state,
    		 @RequestParam(value="price")Double price,
    		 @RequestParam(value="photo")MultipartFile photo,
    		 @RequestParam(value="status")String status,
    		@RequestParam(value="case_type_id")int case_type_id
    		
    		
    		) {
    	 
    		Lawer lawer = new Lawer();
    		 lawer.setName(name);
    		 lawer.setEmail(email);
    		 lawer.setPassword(password);
    		 lawer.setNRC(NRC);
    		 lawer.setPhone(phone);
    		 lawer.setGender(gender);
    		 lawer.setCurrent_state(current_state);
    		 lawer.setPrice(price);
    		 byte[] bytes = null;
 			try {
 				bytes = photo.getBytes();
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
              String encodedPhoto = Base64.getEncoder().encodeToString(bytes);
              lawer.setPhoto(encodedPhoto);
    		 lawer.setStatus(status);
    		 lawer.setCase_type_id(case_type_id);
 
        int rs = lawerRepo.add(lawer);

        if (rs == 0) {
            map.addAttribute("lawer", lawer);
            map.addAttribute("error_msg", "SQL Error: ");
            map.addAttribute("case_types", caseTypeRepo.getAll());
            return "lawers/register";
        } else {
        	map.addAttribute("success_msg", "You can login your lawyer account a few days later when your information are accepted.");
            return "lawers/register";
        }
    }


}
