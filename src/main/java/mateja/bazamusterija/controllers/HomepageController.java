package mateja.bazamusterija.controllers;

import mateja.bazamusterija.Musterija;
import mateja.bazamusterija.dal.DeletedCustomerDAL;
import mateja.bazamusterija.dal.MusterijaDAL;
import mateja.bazamusterija.MusterijaWrapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// Controller used for Filtering and creating and adding new customers
// Possibly change the name

// Kontroler za filtriranje i dodavanje novih musterije
// Verovatno ce biti preimenovana klasa

@RestController
public class HomepageController {

    private final MusterijaDAL musterijaDAL;
    private final DeletedCustomerDAL deletedCustomerDAL;

    @GetMapping(value = "/customers/search")
    public List<MusterijaWrapper> searchCustomers(@RequestParam("value") String query){
        return musterijaDAL.searchCustomers(query);
    }

    @PostMapping(value = "/customers/edit", consumes = "application/json")
    public List<MusterijaWrapper> editCustomer(@RequestBody MusterijaWrapper requestBody){
        return musterijaDAL.editMusterija(requestBody);
    }

    @PostMapping(value = "/customers/delete", consumes = "application/json")
    public List<MusterijaWrapper> deleteCustomer(@RequestBody MusterijaWrapper requestBody){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        deletedCustomerDAL.deleteCustomer(requestBody, date);
        return musterijaDAL.deleteMusterija(requestBody);
    }

    @PostMapping(value = "/customers/new", consumes = "application/json")
    public MusterijaWrapper newCustomer(@RequestBody Musterija requestBody){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        long id = musterijaDAL.getNewestMusterijaId() + 1;
        MusterijaWrapper musterijaWrapper = new MusterijaWrapper(requestBody, id, date, MusterijaWrapper.Status.INCOMPLETE, id);
        musterijaDAL.addNewMusterija(musterijaWrapper);
        return musterijaWrapper;
    }
    List<MusterijaWrapper> musterijaWrappers;

    // Filters customer data and returns it

    // Filtrira podatke musterija i salje ih nazad

    @GetMapping(value = "/customers/filter")
    public List<MusterijaWrapper> filterCustomers(@RequestParam("value") String filterQuery){
            if(filterQuery.equals("completed")) return musterijaDAL.getAllCompleted();
            else if (filterQuery.equals("incomplete")) return musterijaDAL.getAllIncomplete();
            else if(filterQuery.equals("deleted")) return musterijaDAL.deletedCustomerListToMusterijaWrapperList(deletedCustomerDAL.getAllDeletedCustomers());
            return musterijaDAL.getAllCanceled();
    }

    public HomepageController(MusterijaDAL musterijaDAL, DeletedCustomerDAL deletedCustomerDAL){
        this.deletedCustomerDAL = deletedCustomerDAL;
        this.musterijaDAL = musterijaDAL;
    }
}
