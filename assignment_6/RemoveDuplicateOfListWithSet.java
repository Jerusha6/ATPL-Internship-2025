import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateOfListWithSet {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 7,7, 7, 7, 8);

        Set<Integer> set = new HashSet<>(list);
        Collections.sort(list);

        System.out.println(set);

    }
}
