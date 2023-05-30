package pl.ebookstore.app.model;

import pl.ebookstore.app.model.enums.DeliveryType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private static volatile Cart instance; // "volatile" uniemożliwia dostęp do cart wątkowi B, jesli wątek A nie skończył konstruuować obiektu.
    private Map<Long, Integer> ebooks; //<id ebooka, ilosc>
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    private Cart() {
        this.ebooks = new HashMap<>();
        this.deliveryType = DeliveryType.EMAIL;
    }

    public static Cart getInstance() {
        if (instance == null) { // dodatkowy if przyspiesza działanie, przez ograniczenie synchronizacji wątków, tylko do przypadków gdy musi być stworzony nowy obiekt
            synchronized (Cart.class) { // zabezpiecza przed dostepem wielu watkow
                if (instance == null) {
                    instance = new Cart();
                }
            }
        }
        return instance;
    }

}
