package simple.cafekiosk.spring.api.service.order.response;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.stereotype.Service;
import simple.cafekiosk.spring.api.service.product.response.ProductResponse;
import simple.cafekiosk.spring.domain.product.order.OrderProduct;
import simple.cafekiosk.spring.domain.product.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderResponse {

    private Long id;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<ProductResponse> products;
}
