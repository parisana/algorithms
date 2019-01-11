package algorithms;
//A doubly ended linked list is like a dequeue where one can insert at both ends, each node has a next link.
public class DoublyEndedLinkedList {
    Neighbor start;
    Neighbor end;

    public void insertInFirstPosition(String homeOwnerName, int houseNumber){
        Neighbor neighbor= new Neighbor(homeOwnerName, houseNumber);
        if(isEmpty()){
            end= neighbor;
        }
        neighbor.next=start;
        start=neighbor;
    }
    public void insertInLastPosition(String homeOwnerName, int houseNumber){
        Neighbor theNewLink= new Neighbor(homeOwnerName, houseNumber);
        if(isEmpty()){
            start= theNewLink;
        }else {
            end.next = theNewLink;
        }
        end= theNewLink;
    }
    public boolean isEmpty(){
        return start==null;
    }

    public static void main(String[] args){
        DoublyEndedLinkedList theLinkedList= new DoublyEndedLinkedList();
        theLinkedList.insertInFirstPosition("Mark Evans", 7);
        theLinkedList.insertInLastPosition("Dark Evans", 7);
        theLinkedList.insertInFirstPosition("Black Evans", 7);

        theLinkedList.display();
    }
    public void display(){
        Neighbor theLink= start;
        while (theLink!=null){
            theLink.display();
            System.out.println("Next Link: "+ theLink.next);
            theLink=theLink.next;
            System.out.println();
        }
    }
}
class Neighbor{
    public String homeOwnerName;
    public int houseNumber;

    public Neighbor next;

    public Neighbor(String homeOwnerName, int houseNumber){
        this. homeOwnerName= homeOwnerName;
        this.houseNumber=houseNumber;
    }
    public  void display(){
        System.out.println(homeOwnerName+" : "+ houseNumber+" Private drive");
    }
    public String toString(){
        return homeOwnerName;
    }
}
