import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Customer {
    String id;
    String name;
    boolean subscriptionStatus;

    public Customer(String customer_id, String customer_name, boolean subscriptionStatus) {
        id = customer_id;
        name = customer_name;
        this.subscriptionStatus = subscriptionStatus;
    }

}

public class CustomerNotificationSystem {
    public static void main(String[] args) {

        List<Customer> list = new ArrayList<>();
        list.add(new Customer("C101", "Jerusha", true));
        list.add(new Customer("C102", "Rani", false));
        list.add(new Customer("C103", "Elisha", true));
        list.add(new Customer("C104", "Anand", false));
        list.add(new Customer("C105", "Roja", true));

        Consumer<String> consumer = s -> System.out.println(s);

        list.stream()
                .filter(customer -> customer.subscriptionStatus)
                .forEach(customer -> consumer.accept("Thank you for subscribing, " + customer.name + "!"));

    }
}
