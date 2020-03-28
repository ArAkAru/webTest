package Service;

import java.util.List;
import java.util.Optional;

import Entity.Message;

public interface MessageService {
    Message addMes(Message mes);
    void delete(Long id);
    Optional<Message> findId(Long id);
    List<Message> getAll();
    void sayhi();
}
