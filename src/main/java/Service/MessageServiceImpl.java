package Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Entity.Message;
import repMes.repoMes;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private repoMes MessageRep;
	
	public Message addMes(Message mes) {
		Message message =MessageRep.saveAndFlush(mes);
		return message;
	}
	
	public void delete(Long id) {
		MessageRep.deleteById(id);
	}

	public Optional<Message> findId(Long id) {
		
		Optional<Message> ms= MessageRep.findById(id);
		return ms;
	}
	
	public List<Message> getAll() {
		
		return MessageRep.findAll();
	}
	public void sayhi() {
		System.out.println("Hi");
	}

}
