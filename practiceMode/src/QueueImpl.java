
public class QueueImpl{
    public static void main(String[] args){
        Queue queue= new Queue(50, "MyQueue");
        System.out.println(queue.process());
        queue.add(50);
        queue.add(70);
        queue.add(30);
        queue.add(75);

        System.out.println(queue.process());
        System.out.println(queue.process());
        System.out.println(queue.process());
        System.out.println(queue.process());
        System.out.println(queue.process());

    }
}
class Queue{
    Integer items[];
    int size;
    String name;

    int front=0;
    int rear=-1;
    Queue(){
        items= new Integer[50];
    }
    Queue(int size){
        this.size=size;
        items= new Integer[size];
    }
    Queue(int size, String name){
        this.size=size;
        this.name=name;
        items= new Integer[size];
    }

    void add(int item){
        if (rear==size-1){
            System.out.println("Queue is full");
            return;
        }
        items[++rear]=item;
        return;
    }
    Integer process(){
        if(rear<front){
            System.out.println("Queue is empty");
            return null;
        }
        int item=items[rear--];
        return item;
    }
}
