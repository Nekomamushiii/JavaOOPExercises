import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            }
            else if(input[0].equals("Create")){
                Student student = new Student(input[1],Integer.parseInt(input[2]),Double.parseDouble(input[3]));
                studentSystem.add(student);
            }else if(input[0].equals("Show")){
                String str = studentSystem.show(input[1]);
                if(str!=null)
                    System.out.println(str);
            }
        }
    }
}
