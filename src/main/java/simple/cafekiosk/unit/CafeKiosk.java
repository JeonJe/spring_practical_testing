package simple.cafekiosk.unit;

import lombok.Getter;
import simple.cafekiosk.unit.beverage.Beverage;
import simple.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CafeKiosk {

    private static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);
    private static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(10, 0);

    private final List<Beverage> beverages = new ArrayList<>();
    public void add(Beverage beverage, int number) {
        for (int i = 0; i < number; i++) {
            beverages.add(beverage);
        }
    }

    public void remove(Beverage beverage){
        beverages.remove(beverage);
    }

    public void clear() {
        beverages.clear();
    }

    public Order createOrder(LocalDateTime currentDateTime) {
        LocalTime currentTime = currentDateTime.toLocalTime();
        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw new IllegalStateException("영업시간이 아닙니다.");
        }

        return new Order(currentDateTime, beverages);
    }

    public int calculateTotalPrice() {
        return beverages.stream().mapToInt(Beverage::getPrice).sum();
    }

}
