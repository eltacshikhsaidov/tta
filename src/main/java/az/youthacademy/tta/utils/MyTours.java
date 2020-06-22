package az.youthacademy.tta.utils;

import az.youthacademy.tta.entities.OrderItem;
import az.youthacademy.tta.entities.Tours;
import az.youthacademy.tta.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyTours {
    private List<OrderItem> items;

    private TourService tourService;

    @Autowired
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Tours tours = tourService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setTours(tours);
        items.add(orderItem);
    }
}
