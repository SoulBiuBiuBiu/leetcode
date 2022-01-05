import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;

import static java.util.Arrays.sort;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2021/7/13 15:33
 */
public class LambadaTest {

    @Test
    public void t1() {
        String[] strs = {"S", "T"};

        BiFunction<String, String, Integer> comp
                = (first, second) -> first.length() - second.length();
        Integer apply = comp.apply("123", "1");
        sort(strs,
                (first, second) -> {
                    return 1;
                });
        System.out.println(apply);


        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(null);
        list.add("456");
        list.removeIf(Objects::isNull);
        list.add("1");

//        Comparator.comparing().thenComparing()
    }
}
