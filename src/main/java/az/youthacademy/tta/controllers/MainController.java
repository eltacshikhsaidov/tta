package az.youthacademy.tta.controllers;

import az.youthacademy.tta.entities.Tours;
import az.youthacademy.tta.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    private TourService tourService;

    @Autowired
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tours")
    public String shopPage(Model model) {
        List<Tours> allTours = tourService.getAllProducts();
        model.addAttribute("products", allTours);
        return "tours";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Tours> allTours = tourService.getAllProducts();
        model.addAttribute("tour", allTours);
        return "admin";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Tours selectedTours = tourService.getProductById(id);
        model.addAttribute("selectedTour", selectedTours);
        return "details";
    }

    @GetMapping("/find_by_title")
    public String detailsPageByTitle(Model model, @RequestParam("title") String title) {
        Tours selectedTours = tourService.getProductByTitle(title);
        model.addAttribute("selectedProduct", selectedTours);
        return "details";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        tourService.deleteProductById(id);
        return "redirect:/tours";
    }
}
