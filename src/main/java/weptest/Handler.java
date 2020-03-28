package weptest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import Entity.Message;
import Service.MessageService;



@Controller
public class Handler {
	@Autowired
	MessageService messageService;
	@Autowired
	MailSender mailSender;
	public Handler() {
		
	}
//	@RequestMapping
//	public String showPage(HttpServletRequest req,Model model)
//	{
//		
//		return "main-menu";    
//    
//	}
//	@PostMapping
//    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
//		
//		
//		Message mes= new Message(text,tag);
//		messageService.addMes(mes);
//		
//		
//		
//
//        return "main-menu";
//    }
	@RequestMapping("mail-form")
	public String showPage()
	{
		
		return "mail";    
    
	}
	@PostMapping("mail-form")
	public String sendMail(@RequestParam String mail) throws MessagingException {
		System.out.println(mail);
		mailSender.send(mail, "Test mail from ArAkAru", "Howdy");
		return "mail";
			
	}

}
