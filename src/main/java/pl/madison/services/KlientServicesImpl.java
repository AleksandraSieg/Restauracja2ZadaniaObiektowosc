package pl.madison.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.madison.dao.KlientDao;
import pl.madison.domain.Klient;

import java.util.List;

@Service
public class KlientServicesImpl implements IKlientServices {

    @Autowired
    private KlientDao klientDao;

    public List<Klient> findAll() {
        return (List<Klient>) klientDao.findAll();
    }

    public Klient findOne(Long id) {
        return klientDao.findOne(id);
    }

    public Klient save(Klient klient) {
        return klientDao.save(klient);
    }

    public void delete(Long id) {
        klientDao.delete(id);
    }
}
