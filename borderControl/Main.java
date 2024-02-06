package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> personalities = new ArrayList<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {

            String[] data = line.split("\\s+");

            if (data.length == 3) {
                Identifiable citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2]);
                personalities.add(citizen);
            } else if (data.length == 2) {
                Identifiable robot = new Robot(data[0], data[1]);
                personalities.add(robot);
            }

            line = reader.readLine();
        }

        String endNumbers = reader.readLine();

        for (Identifiable person : personalities) {

            if (person.getId().endsWith(endNumbers)) {

                System.out.println(person.getId());
            }
        }
    }
}
