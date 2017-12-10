package pl.madison.services;

import pl.madison.domain.Klient;

import java.util.List;

public interface IKlientServices {

    List<Klient> findAll();
    Klient findOne(Long id);
    Klient save(Klient klient);
    void delete(Long id);
}
