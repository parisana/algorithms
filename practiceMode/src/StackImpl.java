
public class StackImpl{
    public static void main(String[] args){
        Stack stack=new Stack();
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();
    }

}
class Stack{
    int top=-1;
    Integer[] items;
    int size=100;
    String name;
    Stack(int size,String name){
        items=new Integer[size];
        this.size=size;
        this.name=name;
    }Stack(){
        items=new Integer[100];
    }
    void push(int item){
        if (top>items.length-1){
            System.out.println("Stack Overflow ");
            return;
        }
        items[++top]=item;
    }
    int pop(){
        if (top==-1){
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        return items[top--];
    }
}