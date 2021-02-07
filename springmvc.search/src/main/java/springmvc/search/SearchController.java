package springmvc.search;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/user/{userid}/{username}")
	public String getUserDetail(@PathVariable("userid") int userid,@PathVariable("username") String username)
	{
		System.out.println(userid);
		System.out.println(username);
		return "home";
		
	}
	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("going to homeview...");
//		String abc= null;
//		System.out.println(abc.length());		// these line are added for making error Exception
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query)
	{
		String url="https://www.google.com/search?q="+query;
		
		
		RedirectView redirectview=new RedirectView();
		redirectview.setUrl(url);
		
		if(query.isBlank()) 
		{
			redirectview.setUrl("home");
		}
		return redirectview;
	}
	
	
////	handling Exception in spring mvc
////	if we know the which Exception is going to occur than we use these type other wise we use generic Exception handler
//	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)		//status code
//	@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
//	public String exceptionHandlernull(Model model)
//	{
//		model.addAttribute("msg","Error has occured in backend");
//		return"Exception";
//	}
//	
//	
////	generalize Exception mean it is a parent class of all the Exception Class so now any Exception occur than it handle  the Exception(its proffessional way to handle Exception 
//	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({Exception.class})
//	public String exceptionHandlerGeneric(Model model)
//	{
//		model.addAttribute("msg","Error has occured in backend");
//		return"Exception";
//	}
//	
	
}
