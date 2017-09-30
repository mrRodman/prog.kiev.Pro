package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> cl = TestClass.class;
        try {
            TestClass testClass = (TestClass) cl.newInstance();

            Method[] method = cl.getDeclaredMethods();
            for (int i = 0; i < method.length; i++) {
                if (method[i].isAnnotationPresent(Test.class)) {
                    int a = method[i].getAnnotation(Test.class).a();
                    int b = method[i].getAnnotation(Test.class).b();
                    method[i].invoke(testClass, a, b);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
