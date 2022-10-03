package mateja.bazamusterija.controllers;

import mateja.bazamusterija.dal.MusterijaDAL;
import mateja.bazamusterija.MusterijaWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

//Controller used for the index page and the initial load
//Kontroler za prvo ucitavanje stranice

@Controller
public class HomeController {

    private final MusterijaDAL musterijaDAL;
    List<MusterijaWrapper> musterijaWrappers;

    @GetMapping("/")
    public String home(Model model){
        musterijaWrappers = musterijaDAL.getAllMusterije();

        model.addAttribute("musterije",musterijaWrappers);
        return "index";
    }

    public HomeController(MusterijaDAL musterijaDAL){
        this.musterijaDAL = musterijaDAL;
    }
}
