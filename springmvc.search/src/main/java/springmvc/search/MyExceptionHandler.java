package springmvc.search;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
		
//	handle centeralized Exception for that we have to tell spring that these class is for handling exception for that we use @ControllerAdvice 
//	if we know the which Exception is going to occur than we use these type other wise we use generic Exception handler
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)		//status code
	@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
	public String exceptionHandlernull(Model model)
	{
		model.addAttribute("msg","Error has occured in backend");
		return"Exception";
	}
	
	
//	generalize Exception mean it is a parent class of all the Exception Class so now any Exception occur than it handle  the Exception(its proffessional way to handle Exception 
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public String exceptionHandlerGeneric(Model model)
	{
		model.addAttribute("msg","Error has occured in backend");
		return"Exception";
	}
	

}
