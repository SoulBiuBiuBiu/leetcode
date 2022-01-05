import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2021/7/21 11:29
 */
public class RefactorTest {
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(newLength, a.length));
        return newArray;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Integer> integerClass = Integer.class;
        Type[] interfaces = integerClass.getGenericInterfaces();
        Type superclass = integerClass.getGenericSuperclass();
        if (!(superclass instanceof ParameterizedType)) {
            System.out.println("not");
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        Type genericSuperclass = arrayList.getClass().getGenericSuperclass();
        if ((genericSuperclass instanceof ParameterizedType)) {
            System.out.println("yes");
            Type[] params = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            System.out.println("test");
        }

        String name = integerClass.getName();
        integerClass.getTypeName();
        System.out.println("test");




    }
    @Test
    public void testInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer integer = 1;

        Method min = Integer.class.getDeclaredMethod("intValue");
        Object invoke = min.invoke(integer);
        System.out.println(invoke);
    }

    @Test
    public void copyOfTest() {
        Integer[] a = {1, 2, 3};
        a = (Integer[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] objects = (String[]) badCopyOf(a, 10);
    }
}
