package task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> tc = TextContainer.class;
        try {
            TextContainer textContainer = (TextContainer) tc.newInstance();
            String path = tc.getAnnotation(SaveTo.class).path();
            Method[] methods = tc.getDeclaredMethods();

            for (Method m : methods) {
                if (m.isAnnotationPresent(Saver.class)) {
                    m.invoke(textContainer, path);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
