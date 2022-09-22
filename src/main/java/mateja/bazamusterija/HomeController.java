package mateja.bazamusterija;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    List<MusterijaWrapper> musterijaWrappers;

    @GetMapping("/")
    public String home(Model model){
        musterijaWrappers = Customers.getMsts();

        model.addAttribute("musterije",musterijaWrappers);
        return "index";
    }


}
