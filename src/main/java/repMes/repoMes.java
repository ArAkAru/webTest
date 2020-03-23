package repMes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import Entity.Message;
@Repository
public interface repoMes extends JpaRepository<Message, Long> {

}
