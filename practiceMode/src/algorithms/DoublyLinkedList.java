package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

//has next and previous link for each node. start points to next node and last node's next contains null.
class DoublyLinkedList {
    private Node start;
    public Node getStartNode(){
        return start;
    }
    //inserting at the front only. can be inserted from end aswell.
    private void insert(String name, int data) {
        Node newNode = new Node(name, data);
        if (start == null) {
            start = newNode;
        } else{
            newNode.next = start;
            start = newNode;
        }
    }
    private boolean insertAfter(String name, int data, String key){
        Node cursor = start;
        //Node previous=start;
        if (cursor==null)
            return false;
        while (cursor.name!=key){
            cursor=cursor.next;
            if(cursor==null){
                System.out.println(key+" : not found!");
                return false;
            }
        }
        Node newNode= new Node(name, data);
        newNode.next=cursor.next;
        newNode.previous= cursor;
        cursor.next=newNode;
        if (cursor.next!=null)
            cursor.next.previous=newNode;
        return true;
    }
    private Node find(String name){
        Node cursor= start;
        if (cursor==null) {
            System.out.println("List is empty");
            return null;
        }
        while(cursor!=null){
            if (cursor.name==name){
                System.out.println(name+" : found");
                return cursor;
            }
            cursor=cursor.next;
        }
        return null;
    }
    private Node removeFirst(){
        if (start==null){
            System.out.println("List is empty");
            return null;
        }
        System.out.println("REMOVE: "+start);
        start=start.next;
        return start;
    }
    private Node removeLast(){
        Node currentNode= start;
        Node previousNode= null;
        if (currentNode==null){
            System.out.println("list is empty!");
            return null;
        }
        while (currentNode.next!=null){
            previousNode=currentNode;
            currentNode=currentNode.next;
        }
        if (previousNode==null){
            start=null;
            return null;
        }
        previousNode.next=null;//previous node of the node to be deleted.
        currentNode.previous=null;//currentNode is the node to be deleted.
        return currentNode;
    }
    private Node remove(String name){
        Node cursor= start;
        while (cursor!=null){
            if (cursor.name==name){
                return cursor;
            }
            cursor=cursor.next;
        }
        return null;
    }
    private void removeAll() throws IOException {
        System.out.println("Do you wish to remove all the contents of the list? Type yes if you do: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (br.readLine().equalsIgnoreCase("yes")) {
            start = null;
            System.out.println("All items deleted");
            return;
        }else
            System.out.println("Items not deleted!");
        return;
    }
    private void display(){
        Node cursor= start;
        while(cursor!=null){
            System.out.print(cursor);
            System.out.println("\tNext: "+cursor.next);
            cursor = cursor.next;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList myList= new DoublyLinkedList();
        myList.insert("Cola",98);
        myList.insert("Yoke",67);
        myList.insert("Coke",19);
        myList.insertAfter("Pike", 12, "Coke");
        myList.display();
        System.out.println("*****************************************************************");
        /*Iterator it= new DoublyLinkedListIterator(myList);
        while (it.hasNext()){
            System.out.println(it.next());
        }
        try {
            myList.removeAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myList.display();*/
        System.out.println(myList.removeLast());
        System.out.println(myList.removeLast());
        System.out.println(myList.removeLast());
        System.out.println(myList.removeLast());
        System.out.println(myList.removeLast());
    }
}
class Node{
    Node next;
    Node previous;

    String name;
    int data;

    Node(String name,int data){
        this.name= name;
        this.data= data;
    }
    public String toString(){
        return this.name+" "+data;
    }
}
class DoublyLinkedListIterator implements Iterator{
    Node currentNode;
    Node previousNode;

    DoublyLinkedList doublyLinkedList;
    DoublyLinkedListIterator(DoublyLinkedList doublyLinkedList){
        this.doublyLinkedList= doublyLinkedList;
        currentNode=doublyLinkedList.getStartNode();
    }
    @Override
    public boolean hasNext() {
        return currentNode!=null;
    }

    @Override
    public Node next() {
        if (hasNext()){
            Node tempNode= currentNode;
            currentNode=currentNode.next;
            return tempNode;
        }
        return null;
    }
}