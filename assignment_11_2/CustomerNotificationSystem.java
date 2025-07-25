import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class customer {
    String id;
    String name;
    double salary;
    boolean subscriptionStatus;

    public customer(String customer_id, String customer_name, boolean subscriptionStatus) {
        id = customer_id;
        name = customer_name;
        this.subscriptionStatus = subscriptionStatus;
    }

}

public class CustomerNotificationSystem {
    public static void main(String[] args) {

        List<customer> list = new ArrayList<>();
        list.add(new customer("C101", "Jerusha", true));
        list.add(new customer("C102", "Rani", false));
        list.add(new customer("C103", "Elisha", true));
        list.add(new customer("C104", "Anand", false));
        list.add(new customer("C105", "Roja", true));

        Consumer<String> consumer = s -> System.out.println(s);

        list.stream()
                .filter(customer -> customer.subscriptionStatus)
                .forEach(c -> consumer.accept("Thank you for subscribing, " + c.name + "!"));

    }
}
