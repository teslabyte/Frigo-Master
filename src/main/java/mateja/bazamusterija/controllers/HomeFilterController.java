package mateja.bazamusterija.controllers;

import mateja.bazamusterija.Musterija;
import mateja.bazamusterija.dal.MusterijaDAL;
import mateja.bazamusterija.MusterijaWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller used for Filtering and creating and adding new customers
// Possibly change the name

// Kontroler za filtriranje i dodavanje novih musterije
// Verovatno ce biti preimenovana klasa

@RestController
public class HomeFilterController {

    private final MusterijaDAL musterijaDAL;

    /*
        Try with GetMapping  /filter= {completed,incomplete,cancelled}

        Pokusaj da tri glavna filtera obuhvatis jednim url-om ^
     */

    @PostMapping(value = "/customer/new", consumes = "application/json")
    public void testPost(@RequestBody Musterija requestBody){
        System.out.println(requestBody.getIme());
    }
    List<MusterijaWrapper> musterijaWrappers;

    // Filters customer data and returns it

    // Filtrira podatke musterija i salje ih nazad
    @GetMapping(value = "/completed", produces = "application/json")
    public List<MusterijaWrapper> homeCompleted(){

        return musterijaDAL.getAllCompleted();
    }

    @GetMapping(value = "/incomplete", produces = "application/json")
    public List<MusterijaWrapper> homeIncomplete(){
        return musterijaDAL.getAllIncomplete();
    }

    @GetMapping(value = "/canceled", produces = "application/json")
    public List<MusterijaWrapper> homeCancelled(){
        return musterijaDAL.getAllCanceled();
    }

    public HomeFilterController( MusterijaDAL musterijaDAL){
        this.musterijaDAL = musterijaDAL;
    }
}
