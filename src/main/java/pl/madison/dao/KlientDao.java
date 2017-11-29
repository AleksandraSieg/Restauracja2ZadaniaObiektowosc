package pl.madison.dao;


import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Klient;

public interface KlientDao extends CrudRepository<Klient, Long>{
}
