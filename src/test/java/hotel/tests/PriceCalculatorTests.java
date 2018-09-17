package hotel.tests;

import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.util.PriceCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceCalculatorTests {

    private static Room room;
    private static List<Feature> features;
    private PriceCalculator priceCalculator;


    @BeforeAll
    static void setup(){
        room = new Room();

        features = new ArrayList<>();
        Feature feature = new Feature("HUI", 50);



        features.add(feature);
    }

    @Test
    void priceCalculationCorrect(){
        room.setPrice(50);

        double actual = priceCalculator.getPrice(room, features);
        double expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    void priceCalculationFailedWithNegativePrice(){
        room.setPrice(-1999);

        double actual = priceCalculator.getPrice(room, features);
        double expected = -1;

        assertEquals(expected, actual);
    }
}
