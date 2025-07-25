import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ProductDiscountApplication {
    public static void main(String[] args) {

        Map<String, Optional<Double>> productMap = new HashMap<>();

        productMap.put("Refrigerator", Optional.ofNullable(80000.0));
        productMap.put("Sony TV", Optional.ofNullable(58999.0));
        productMap.put("Lenovo laptop", Optional.ofNullable(78999.0));
        productMap.put("Charger", Optional.ofNullable(null));
        productMap.put("Mac Book", Optional.ofNullable(120000.0));
        productMap.put("ThinkPad", Optional.ofNullable(null));
        productMap.put("Samsung A35", Optional.ofNullable(35000.0));

        Function<Double, Double> discoutFunction = price -> price * 0.9; // discount =>10% so price - (0.1 * price) => // price*(1-0.1)
                                                                         

        productMap.forEach((product, OptionalPrice) -> {
            if (OptionalPrice.isPresent()) {
                double discounted = discoutFunction.apply(OptionalPrice.get());
                System.out.println(product + " discounted price: " + discounted);
            } else {
                System.out.println(product + " price not available");
            }
        });

    }
}