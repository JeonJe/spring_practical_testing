package simple.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import simple.cafekiosk.unit.beverage.Americano;
import simple.cafekiosk.unit.beverage.Latte;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CafeKioskTest {
    
    @Test
    void add() {

        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano(),1);

        assertThat(cafeKiosk.getBeverages()).hasSize(1);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
        assertThat(cafeKiosk.getBeverages().get(0).getPrice()).isEqualTo(4000);
    }

    @Test
    void remove() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano, 1);
        assertThat(cafeKiosk.getBeverages()).hasSize(1);

        cafeKiosk.remove(americano);
        assertThat(cafeKiosk.getBeverages()).hasSize(0);
    }

    @Test
    void clear() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano, 1);
        cafeKiosk.add(latte, 1);
        assertThat(cafeKiosk.getBeverages()).hasSize(2);

        cafeKiosk.clear();
        assertThat(cafeKiosk.getBeverages()).hasSize(0);
    }

    @Test
    void calculateTotalPrice() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano, 1);
        cafeKiosk.add(latte, 1);

        int totalPrice = cafeKiosk.calculateTotalPrice();

        assertThat(totalPrice).isEqualTo(8500);
    }

    @Test
    void addSeveralBeverages() {
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        //when
        cafeKiosk.add(americano, 2);
        //then
        assertThat(cafeKiosk.getBeverages()).hasSize(2);
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
        assertThat(cafeKiosk.getBeverages().get(1).getName()).isEqualTo("아메리카노");
    }

}