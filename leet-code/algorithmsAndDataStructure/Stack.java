package algorithmsAndDataStructure;
import java.util.*;
public class Stack {
    List<Integer> stack = new ArrayList<>();

    public Stack(){
    }

    public void push (int n) {
        stack.add(n);
    }

    public Integer pop(){
        if (stack.size() > 0)
            return stack.remove(stack.size() - 1);
        return null;
    }

    public Integer peek() {
        if(stack.size() > 0)
            return stack.get(stack.size() - 1);
        return null;
    }

    public Integer size() {
        return stack.size();
    }

    public static void main(String[] args) {
        var stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}