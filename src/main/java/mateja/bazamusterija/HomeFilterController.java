package mateja.bazamusterija;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeFilterController {

    /*
        Try with GetMapping  /filter= {completed,incomplete,cancelled}
     */

    @PostMapping(value = "/customer/new", consumes = "application/json")
    public void testPost(@RequestBody Musterija requestBody){
        System.out.println(requestBody.getIme());
    }
    List<MusterijaWrapper> musterijaWrappers;

    @GetMapping(value = "/completed", produces = "application/json")
    public List<MusterijaWrapper> homeCompleted(){
        List<MusterijaWrapper> completed = new ArrayList<>();
        musterijaWrappers = Customers.getMsts();
        for(MusterijaWrapper mw : musterijaWrappers){
            if (mw.getStatus() == MusterijaWrapper.Status.COMPLETED) completed.add(mw);
        }

        return completed;
    }

    @GetMapping(value = "/incomplete", produces = "application/json")
    public List<MusterijaWrapper> homeIncomplete(){
        List<MusterijaWrapper> completed = new ArrayList<>();
        musterijaWrappers = Customers.getMsts();
        for(MusterijaWrapper mw : musterijaWrappers){
            if (mw.getStatus() == MusterijaWrapper.Status.INCOMPLETE) completed.add(mw);
        }

        return completed;
    }

    @GetMapping(value = "/cancelled", produces = "application/json")
    public List<MusterijaWrapper> homeCancelled(){
        List<MusterijaWrapper> completed = new ArrayList<>();
        musterijaWrappers = Customers.getMsts();
        for(MusterijaWrapper mw : musterijaWrappers){
            if (mw.getStatus() == MusterijaWrapper.Status.CANCELED) completed.add(mw);
        }

        return completed;
    }
}
