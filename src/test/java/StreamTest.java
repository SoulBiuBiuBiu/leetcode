import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2021/7/13 15:10
 */
public class StreamTest {
    @Test
    public void flatMapTest() {

        List<Stu> stus = new ArrayList<>();
        stus.add(new Stu("1"));
        stus.add(new Stu("2"));
        stus.add(new Stu("3"));
        List<Stu> stus1 = stus.stream().filter(t -> t.name.equals("1")).collect(toList());
        stus1.get(0).name = "2";

    }

    @Test
    public void t1() {
        String[] words = new String[]{"Hello", "World"};
        Stream<String> stream1 = Stream.of(words);
        Stream<String[]> stream = stream1.map(i -> i.split(""));

        List<String> collect = stream.flatMap(Stream::of).collect(toList());
        System.out.println(collect);
    }

    class Stu {
        private String name;

        Stu(String name) {
            this.name = name;
        }
    }


}
