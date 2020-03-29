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

	@RequestMapping
	public String showPage()
	{
		
		return "mail";    
    
	}
	@PostMapping
	public String sendMail(@RequestParam String mail,@RequestParam String head,@RequestParam String text) throws MessagingException {
		Message mes= new Message(text,head,mail);
		messageService.addMes(mes);
		mailSender.send(mail, head, text);
		return "mail";
			
	}

}
