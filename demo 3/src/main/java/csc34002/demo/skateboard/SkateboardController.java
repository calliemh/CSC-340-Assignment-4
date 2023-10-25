package csc34002.demo.skateboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Callie Hampton
 */
@Controller
@RequestMapping("/")
public class SkateboardController {
    SkateboardService skateboardService;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("skateboardList",
                skateboardService.getAllSkateboards());
        return "shop";
    }

    /*@GetMapping("/skateboard/id={ProductTYPE}")
    public String edit(@PathVariable String ProductTYPE, Model model) {
        model.addAttribute("product", skateboardService.findByType(ProductTYPE));
        return "edit";
    }*/
}
