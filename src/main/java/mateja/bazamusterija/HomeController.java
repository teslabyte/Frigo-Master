package mateja.bazamusterija;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    Musterija m1 = new Musterija("Mateja","1234565","klima ugradnja","Svetosavska 123", 12000);
    Musterija m2 = new Musterija("Boban","54341234","frizider","Svetosavska 345", 8500);
    Musterija m3 = new Musterija("John","123123154","zamrzivac","Svetosavska 555", 10000);
    Musterija m4 = new Musterija("Jack","345345345","rerna","Svetosavska 1", 3500);
    Musterija m5 = new Musterija("Ted","6786786","masina za ves","Svetosavska 3E", 2850);

    @GetMapping("/")
    public String home(Model model){
        ArrayList<Musterija> musterije = new ArrayList<>();
        musterije.add(m1);
        musterije.add(m2);
        musterije.add(m3);
        musterije.add(m4);
        musterije.add(m5);

        model.addAttribute("musterije",musterije);
        return "index";
    }

}
