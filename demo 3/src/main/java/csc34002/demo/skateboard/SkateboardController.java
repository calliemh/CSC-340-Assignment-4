package csc34002.demo.skateboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author Callie Hampton
 */
@Controller
@RequestMapping("/")
public class SkateboardController {
    @Autowired
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

    @GetMapping("/skateboard/id={ProductId}")
    public String edit(@PathVariable long ProductId, Model model) {
        model.addAttribute("skateboard", skateboardService.findById(ProductId));
        return "edit";
    }

    @PostMapping("/create")
    public String create(Skateboard skateboard) {
        skateboardService.saveSkateboard(skateboard);
        return "redirect:/shop";
    }

    @PostMapping("/delete/id={ProductID}")
    public String delete(@PathVariable long ProductID) {
        skateboardService.deleteSkateboard(ProductID);
        return "redirect:/shop";
    }

    @PostMapping("/edit")
    public String edit(Skateboard skateboard) {
        skateboardService.saveSkateboard(skateboard);
        return "redirect:/shop";
    }

}
