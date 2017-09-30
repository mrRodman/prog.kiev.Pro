package task3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Container implements Externalizable {
    private int number1;

    @Save
    private int number2;

    private String text;

    @Save
    private char[] chars;

    @Save
    private double[] doubles;

    public Container(int number1, int number2, String text, char[] chars, double[] doubles) {
        this.number1 = number1;
        this.number2 = number2;
        this.text = text;
        this.chars = chars;
        this.doubles = doubles;
    }

    public Container() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Class<?> cont = Container.class;

        Field[] fields = cont.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                try {
                    out.writeObject(f.get(this));
                } catch (IllegalAccessException e) {

                }
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Class<?> cont = Container.class;

        Field[] fields = cont.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                try {
                    f.set(this, in.readObject());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public double[] getDoubles() {
        return doubles;
    }

    public void setDoubles(double[] doubles) {
        this.doubles = doubles;
    }

    @Override
    public String toString() {
        return "Container{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", text='" + text + '\'' +
                ", chars=" + Arrays.toString(chars) +
                ", doubles=" + Arrays.toString(doubles) +
                '}';
    }
}
