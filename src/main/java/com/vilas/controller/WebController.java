package com.vilas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vilas.beans.Emp;
import com.vilas.service.EmpService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class WebController
{	
	@Autowired
	EmpService service;
	
	public static final Logger logger = LogManager.getLogger(WebController.class);
	
	
	@InitBinder
	public void initFormatter(WebDataBinder binder)
	{
	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@RequestMapping("/")
	public String home()
	{	
		logger.info("Vilas WebController Login Page ");
		
		return "login";
	}

	@RequestMapping("/login")
	public String login(String uname, String pass, ModelMap model, HttpServletRequest request, HttpSession session)
	{ 	logger.debug("Vilas Try credentials ...");
		if(uname!=null && pass!=null && uname.equals("1") && pass.equals("1"))
		{
			logger.debug("Vilas Login success ...");
			if(request.getSession(false) != null)
			{	
			model.put("emp_list", service.getAllEmp());
			}
			session.setAttribute("uname", uname);
			return "home";
		}
		else
		{
			logger.debug("Login fail ... uname - "+uname+" pass -"+pass);
			model.put("message","Invalid credentials...");
			
			return "login";
		}

			
	}
	
	
	@RequestMapping("/logout")
	public String loginOut(HttpServletRequest request)
	{ 	logger.debug("Vilas Logout ...");
		
		request.getSession().invalidate();
        
			return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home(String uname, String pass, ModelMap model, HttpServletRequest request, HttpSession session)
	{ 
		if(request.getSession(false) != null)
		{	
		model.put("emp_list", service.getAllEmp());
		}
		model.addAttribute("uname", session.getAttribute("uname"));
		return "home";
	}

	@RequestMapping("/delete-emp/{id}")
	public String delete_emp(@PathVariable int id, ModelMap model, HttpSession session)
	{ 
		if(!session.isNew())
		{	
		service.deleteEmp(id);
		
		model.put("emp_list", service.getAllEmp());
		}
		return "redirect:/home";
	}

	@RequestMapping("/aadEmp")
	public String addEmp(ModelMap model)
	{ 	
		model.addAttribute("command1", new Emp());
		
		return "emp";
	}

	@RequestMapping(value = "/finalAddOrUpdate", method = RequestMethod.POST)
	public String finalAddOrUpdateMethod(  @Valid @ModelAttribute("command1") Emp e, BindingResult br)
	{ 	
		if(br.hasErrors())  
		{  
			return "emp";  
		}  

		//service.deleteEmp(e.getSecretValue());
		service.addEmp(e);
		return "redirect:/home";
	}

	@RequestMapping("/updateEmp2/{id}")
	public String updateEmp(@PathVariable("id") int id, ModelMap model)
	{ 	
		Emp e = (Emp)service.getEmp(id).get();
		System.out.println(e.toString());
		model.addAttribute("command1", e);
		return "emp";
	}

	@RequestMapping("/update-emp/{id}")
	public String uppdate_emp(@PathVariable int id, ModelMap model)
	{ 
		return "redirect:/updateEmp2/"+id;
	}


}
