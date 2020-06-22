package az.youthacademy.tta.controllers;

import az.youthacademy.tta.entities.User;
import az.youthacademy.tta.services.UserService;
import az.youthacademy.tta.services.OrderService;
import az.youthacademy.tta.utils.MyTours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/myTours")
public class MyToursController {
    private MyTours cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setCart(MyTours cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("items", cart.getItems());
        return "myTours";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        return "redirect:/tours";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        orderService.createOrderFromItems(user, cart.getItems());
        return "redirect:/tours";
    }
}
