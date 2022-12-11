package sg.nus.iss.login.logout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginLogoutController {
	@GetMapping("/login")
	  public String login() {
	    return "login";
	  }
	  
	  @PostMapping("/login") 
	  public String handleLogin(ModelMap m, @RequestParam("username") String username, @RequestParam("password") String password, 
	                                Model model, HttpSession session) 
	  {
		  if ((username.equals("admin") && password.equals("1234"))||
			  (username.equals("manager") && password.equals("asdf"))||
			  (username.equals("staff") && password.equals("asd123"))) {
			  
		      session.setAttribute("username", username);
		      m.put("username", username);

		      return "welcome";
		    }
	    return "login";
	  }
	  

	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
	    
		  session.invalidate();
		    
		  return "redirect:/login";
	  }
}
