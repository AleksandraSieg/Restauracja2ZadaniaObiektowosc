package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.domain.Klient;
import pl.madison.services.IKlientServices;

import java.util.List;

@RestController
public class TestController {

//    @Autowired
//    private KlientDao klientRespository;

    @Autowired
    private IKlientServices iKlientServices;

    @RequestMapping(value = "/wyswietl", method = RequestMethod.GET)
    public List<Klient> wyswietl(){

        return (List<Klient>) iKlientServices.findAll();
    }

    @RequestMapping(value = "/sredniaArytmetyczna", method = RequestMethod.GET)
    public String srednia(){
        String srednia = "";
        double suma = 0;

        for (Klient klient : iKlientServices.findAll()) {
            suma = suma + klient.getRachunek();
        }

        double sredniaArytm = suma/((List<Klient>)iKlientServices.findAll()).size();

        return srednia + sredniaArytm;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("rachunek") double rachunek){

        Klient zamianaKlienta = iKlientServices.findOne(id);
        zamianaKlienta.setRachunek(rachunek);
        iKlientServices.save(zamianaKlienta);

        return "Udalo Ci sie poprawic Rachunek :)";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        iKlientServices.delete(id);
        return "Usunales klienta i jego rachunek";
    }

    @RequestMapping(value = "/dodaj", method = RequestMethod.PUT)
    public String dodaj(@RequestParam("nazwisko") String nazwisko, @RequestParam("rachunek") double rachunek){
        Klient nowyKlient = Klient.builder().nazwisko(nazwisko).rachunek(rachunek).build();
        iKlientServices.save(nowyKlient);

        return "Jupi kolejny klient zaplacil :)";
    }
}
