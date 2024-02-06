import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push (String element){
        this.data.add(element);
    }

    public String pop(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("StackOfStrings is Empty");
        }
        return this.data.remove(this.data.size() - 1);
    }

    public boolean isEmpty (){
        return this.data.isEmpty();
    }

    public String peek(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("StackOfStrings is Empty");
        }

        return this.data.get(this.data.size() - 1);
    }
}

