package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.KlientDao;
import pl.madison.domain.Klient;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private KlientDao klientRespository;

    @RequestMapping(value = "/wyswietl", method = RequestMethod.GET)
    public String wyswietl(){
        String klient = "";

        for (Klient klient1 : klientRespository.findAll()) {
            klient = klient + klient1;
        }

        return klient;
    }

    @RequestMapping(value = "/sredniaArytmetyczna", method = RequestMethod.GET)
    public String srednia(){
        String srednia = "";
        double suma = 0;

        for (Klient klient : klientRespository.findAll()) {
            suma = suma + klient.getRachunek();
        }

        double sredniaArytm = suma/((List<Klient>)klientRespository.findAll()).size();

        return srednia + sredniaArytm;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("rachunek") double rachunek){

        Klient zamianaKlienta = klientRespository.findOne(id);
        zamianaKlienta.setRachunek(rachunek);
        klientRespository.save(zamianaKlienta);

        return "Udalo Ci sie poprawic Rachunek :)";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        klientRespository.delete(id);
        return "Usunales klienta i jego rachunek";
    }

    @RequestMapping(value = "/dodaj", method = RequestMethod.PUT)
    public String dodaj(@RequestParam("nazwisko") String nazwisko, @RequestParam("rachunek") double rachunek){
        Klient nowyKlient = new Klient();
        nowyKlient.setNazwisko(nazwisko);
        nowyKlient.setRachunek(rachunek);
        klientRespository.save(nowyKlient);

        return "Jupi kolejny klient zaplacil :)";
    }
}
