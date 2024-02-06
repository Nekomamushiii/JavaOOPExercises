package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Class<RichSoilLand> richSoilLandClass =RichSoilLand.class;
		Field[] fields = richSoilLandClass.getDeclaredFields();
		String command = scanner.nextLine();

		Consumer<Field> print = e-> System.out.printf("%s %s %s\n",Modifier.toString(
				e.getModifiers()),
				e.getType().getSimpleName(),
				e.getName());

		while (!command.equals("HARVEST")){
			if(command.equals("all"))
				Arrays.stream(fields).forEach(print);
			else {
				String finalCommand = command;
				Arrays.stream(fields).filter(e->Modifier.toString(e.getModifiers()).equals(finalCommand))
						.forEach(print);
			}
			command=scanner.nextLine();
		}
	}
}
