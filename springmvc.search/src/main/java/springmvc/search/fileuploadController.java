package springmvc.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class fileuploadController {

	@RequestMapping("/fileform")
	public String showuploadForm()
	{
		return "fileform";
	}
	
	@RequestMapping(path="/uploadimage",method=RequestMethod.POST)
	public String fileHandler(@RequestParam("profile") CommonsMultipartFile file,HttpSession s,Model model) throws IOException
	{
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
		
		byte[] data = file.getBytes();		//file is save in data variable in byte form
		
		//we have to save this file to server
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+ File.separator +"resources"+ File.separator +"image"+ File.separator +file.getOriginalFilename();
		System.out.println(path);
		
		try 
		{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data); 
			fos.close();
			System.err.println("file uploded");
			
			model.addAttribute("msg","Uploaded Successfully");
			model.addAttribute("filename",file.getOriginalFilename());
			  
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("uploading error");
			model.addAttribute("msg","Uploading Error");
		}
	
		
		return "filesuccess";
	}
}
