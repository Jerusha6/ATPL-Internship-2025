import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class Users {
    String id;
    String name;
    String email;

    public Users(String user_id, String user_name, String email) {
        id = user_id;
        name = user_name;
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

}

public class UserSearchEmailTransformation {
    public static void main(String[] args){
        List<Users> list = new ArrayList<>();
        list.add(new Users("U101", "Jerusha", "jerusha@gmail.com"));
        list.add(new Users("U102", "Rani", null));
        list.add(new Users("U103", "Elisha", "elisha@gmail.com"));
        list.add(new Users("U104", "Anand", null));
        list.add(new Users("U105", "Roja", "roja@gmail.com"));


        Function<String, String> toUpper = String::toUpperCase;
        list.stream() .forEach(user -> {
            System.out.println("User ID: "+ user.id+"\nUser name: "+ user.name+"\nEmail: "+ toUpper.apply(user.getEmail().orElse("User email is not available!")));
        });

    }
}
