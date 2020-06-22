package az.youthacademy.tta.services;

import az.youthacademy.tta.entities.Order;
import az.youthacademy.tta.entities.OrderItem;
import az.youthacademy.tta.entities.User;
import az.youthacademy.tta.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUser(user);
        items.stream().forEach(item -> {
            order.getItems().add(item);
            item.setOrder(order);
        });
        items.clear();
        return orderRepository.save(order);
    }
}
