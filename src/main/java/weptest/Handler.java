package weptest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Message;
import Service.MessageService;
import Service.MessageServiceImpl;
import repMes.repoMes;

@Controller
public class Handler {
	@Autowired
	MessageService messageService;
	
	public Handler() {
		
	}
	@RequestMapping
	public String showPage(HttpServletRequest req,Model model)
	{
		return "main-menu";    
    
	}
	@PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
		
		
		Message mes= new Message(text,tag);
		messageService.addMes(mes);
		
		
		

        return "main-menu";
    }

}
