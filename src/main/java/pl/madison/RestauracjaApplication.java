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

    @Autowired
    private KlientDao klientRespository;
    public void run(String... strings) throws Exception {
        Klient klient1 = new Klient();
        klient1.setNazwisko("Kowalski");
        klient1.setRachunek(78.90);
        klientRespository.save(klient1);

        Klient klient2 = new Klient();
        klient1.setNazwisko("Nowak");
        klient1.setRachunek(56.67);
        klientRespository.save(klient2);

        Klient klient3 = new Klient();
        klient3.setNazwisko("Jaworski");
        klient3.setRachunek(100.00);
        klientRespository.save(klient3);
    }
}
