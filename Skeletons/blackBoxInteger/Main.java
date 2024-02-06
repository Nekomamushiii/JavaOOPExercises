package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner=new Scanner(System.in);
        Constructor<BlackBoxInt> constructor= BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Method[] methods= blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] data = command.split("_");
            Method method = Arrays.stream(methods).filter(e->e.getName().equals(data[0])).findFirst().orElse(null);
            method.setAccessible(true);
            method.invoke(blackBoxInt,Integer.parseInt(data[1]));
            System.out.println(innerValue.get(blackBoxInt));
            command=scanner.nextLine();
        }
    }
}
