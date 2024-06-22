package simple.cafekiosk.spring.api.service.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import simple.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import simple.cafekiosk.spring.api.service.order.response.OrderResponse;
import simple.cafekiosk.spring.domain.order.OrderRepository;
import simple.cafekiosk.spring.domain.product.Product;
import simple.cafekiosk.spring.domain.product.ProductRepository;
import simple.cafekiosk.spring.domain.order.Order;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Getter
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }
}
