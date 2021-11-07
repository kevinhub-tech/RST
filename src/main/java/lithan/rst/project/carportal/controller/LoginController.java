package lithan.rst.project.carportal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lithan.rst.project.carportal.entities.Car;
import lithan.rst.project.carportal.entities.User;
import lithan.rst.project.carportal.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

    @RequestMapping(value="/login",  method= RequestMethod.GET)
    public String onLogin() {
        return "login";
    }


    @RequestMapping(value="/login_error")
    public String onLoginError(Model model) {
        String error_msg = "Incorrect username or password. Try Again.";
        model.addAttribute("error_string", error_msg);
        return "login";
    }
    
    @RequestMapping(value="/new")
	public String newUserForm(Map<String, Object> model) {
    	System.out.println("/new Login Controller");
		User user = new User();
		model.put("user", user);
		return "new_user";
	}
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStore(@ModelAttribute("user") User user, Model model) {
		System.out.println("/save Login Controller");
		userService.save(user);
		String register_success = "<h5> Registeration Successful! </h5>";
		model.addAttribute("register_success", register_success);
		return "new_user";
	}
	
	
    @RequestMapping(value="users",  method= RequestMethod.GET)
    public String viewUsers(Model model) {
        List<User> users = userService.listAll();
        if(!CollectionUtils.isEmpty(users)) {
            model.addAttribute("userlists", users);
        }
        return "all_user";
    }
    
    
    @RequestMapping(value="/about",  method= RequestMethod.GET)
    public String about() {
        return "aboutUs";
    }
    
    
    @RequestMapping(value="/contact",  method= RequestMethod.GET)
    public String contact() {
        return "contactUs";
    }
}
