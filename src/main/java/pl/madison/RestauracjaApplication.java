package pl.madison;

//2. Stwórz restaurację, w której będzie lista klientów wraz z ich rachunkiem.
// Wyświetl średnią arytmetyczną rachunków.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.KlientDao;
import pl.madison.domain.Klient;

@SpringBootApplication
public class RestauracjaApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(RestauracjaApplication.class, args);
    }

    public Klient createKlient(String nazwisko, double rachunek){
        Klient kl = Klient.builder().nazwisko(nazwisko).rachunek(rachunek).build();
        return kl;
    }

    @Autowired
    private KlientDao klientRespository;
    public void run(String... strings) throws Exception {
        Klient klient1 = Klient.builder().nazwisko("Kowalski").rachunek(78.90).build();
        klientRespository.save(klient1);

        Klient klient2 = Klient.builder().nazwisko("Nowak").rachunek(56.67).build();
        klientRespository.save(klient2);

        Klient klient3 = Klient.builder().nazwisko("Jaworski").rachunek(100.00).build();
        klientRespository.save(klient3);
    }
}
