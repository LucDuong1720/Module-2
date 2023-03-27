import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.peek());  // Loại bỏ phần tử ở đỉnh của Stack
        stack.pop(); // In ra phần tử ở đỉnh của Stack
        System.out.println("Top element: " + stack.peek()); // Kiểm tra xem Stack có rỗng hay không
        if (stack.empty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }
}
