import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;


    public StudentSystem(){
       this.repo = new HashMap<>();
    }


    public void add(Student student){
       if(!this.repo.containsKey(student.getName()))
           this.repo.put(student.getName(),student);
    }
    public String show(String name){
        if(this.repo.containsKey(name)){
            Student student = this.repo.get(name);
            String str = String.format("%s is %d years old. ",student.getName(),student.getAge());
            if(student.getGrade()>=5.00)
                return  str+="Excellent student.";
            else if(student.getGrade()<5.00 && student.getGrade()>=3.50)
                return str+="Average student.";
            else return str+="Very nice person.";
        }
        return null;
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }


}
