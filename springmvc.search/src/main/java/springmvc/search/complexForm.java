package springmvc.search;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class complexForm {
	
	@RequestMapping("/complex")
	public String showform()
	{
		
		return "complex_form";
		
	}
	
	@RequestMapping(path="/handle",method=RequestMethod.POST)
	public String formhandle(@ModelAttribute("student") Student student, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "complex_form";
		}
		System.out.println(student);
		System.out.println(student.getAddress());
		return "success";
	}

}
