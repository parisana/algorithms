/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *
 *****************************************************************************/

import java.util.*;

public class CustomLinkedListImpl<AnyType> implements Iterable<AnyType>{
    private Node<AnyType> head;

    public CustomLinkedListImpl(){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(AnyType item){
        head = new Node<AnyType>(item, head);
    }
    public AnyType getFirst(){
        if(head == null) throw new NoSuchElementException();

        return head.data;
    }
    public AnyType removeFirst(){
        AnyType tmp = getFirst();
        head = head.next;
        return tmp;
    }
    public void addLast(AnyType item){
        if( head == null)
            addFirst(item);
        else{
            Node<AnyType> tmp = head;
            while(tmp.next != null) tmp = tmp.next;

            tmp.next = new Node<AnyType>(item, null);
        }
    }
    public AnyType getLast(){
        if(head == null) throw new NoSuchElementException();

        Node<AnyType> tmp = head;
        while(tmp.next != null) tmp = tmp.next;

        return tmp.data;
    }
    public void clear(){
        head = null;
    }
    public boolean contains(AnyType x){
        for(AnyType tmp : this)
            if(tmp.equals(x)) return true;

        return false;
    }
    public AnyType get(int pos){
        if (head == null) throw new IndexOutOfBoundsException();

        Node<AnyType> tmp = head;
        for (int k = 0; k < pos; k++) tmp = tmp.next;

        if( tmp == null) throw new IndexOutOfBoundsException();

        return tmp.data;
    }
    public String toString(){
        StringBuffer result = new StringBuffer();
        for(Object x : this)
            result.append(x + " ");

        return result.toString();
    }
    public void insertAfter(AnyType key, AnyType toInsert){
        Node<AnyType> tmp = head;

        while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

        if(tmp != null)
            tmp.next = new Node<AnyType>(toInsert, tmp.next);
    }
    public void insertBefore(AnyType key, AnyType toInsert){
        if(head == null) return;

        if(head.data.equals(key)){
            addFirst(toInsert);
            return;
        }

        Node<AnyType> prev = null;
        Node<AnyType> cur = head;

        while(cur != null && !cur.data.equals(key)){
            prev = cur;
            cur = cur.next;
        }
        //insert between cur and prev
        if(cur != null)
            prev.next = new Node<AnyType>(toInsert, cur);
    }
    /**
     *  Removes the first occurrence of the specified element in this list.
     *
     */
    public void remove(AnyType key){
        if(head == null)
            throw new RuntimeException("cannot delete");

        if( head.data.equals(key) ){
            head = head.next;
            return;
        }

        Node<AnyType> cur  = head;
        Node<AnyType> prev = null;

        while(cur != null && !cur.data.equals(key) ){
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
    }
    /**
     *  Returns a deep copy of the list
     *  Complexity: O(n^2)
     */
    public  CustomLinkedListImpl<AnyType> copy1(){
        CustomLinkedListImpl<AnyType> twin = new CustomLinkedListImpl<AnyType>();
        Node<AnyType> tmp = head;
        while(tmp != null){
            twin.addLast( tmp.data );
            tmp = tmp.next;
        }

        return twin;
    }
    /**
     *  Returns a deep copy of the list
     *  Complexity: O(n)
     */
    public CustomLinkedListImpl<AnyType> copy2(){
        CustomLinkedListImpl<AnyType> twin = new CustomLinkedListImpl<AnyType>();
        Node<AnyType> tmp = head;
        while(tmp != null){
            twin.addFirst( tmp.data );
            tmp = tmp.next;
        }

        return twin.reverse();
    }
    /**
     *  Reverses the list
     *  Complewxity: O(n)
     */
    public CustomLinkedListImpl<AnyType> reverse(){
        CustomLinkedListImpl<AnyType> list = new CustomLinkedListImpl<AnyType>();
        Node<AnyType> tmp = head;
        while(tmp != null){
            list.addFirst( tmp.data );
            tmp = tmp.next;
        }
        return list;
    }
    /**
     *  Returns a deep copy of the immutable list
     *  It uses a tail reference.
     *  Complexity: O(n)
     */
    public CustomLinkedListImpl<AnyType> copy3(){
        CustomLinkedListImpl<AnyType> twin = new CustomLinkedListImpl<AnyType>();
        Node<AnyType> tmp = head;
        if(head==null) return null;
        twin.head = new Node<AnyType>(head.data, null);
        Node<AnyType> tmpTwin = twin.head;
        while(tmp.next != null){
            tmp = tmp.next;
            tmpTwin.next = new Node<AnyType>(tmp.data, null);
            tmpTwin = tmpTwin.next;
        }

        return twin;
    }

    /*******************************************************
     *
     *  The Node class
     *
     ********************************************************/
    private static class Node<AnyType>{
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next){
            this.data = data;
            this.next = next;
        }
    }

    /*******************************************************
     *
     *  The Iterator class
     *
     ********************************************************/

    public Iterator<AnyType> iterator(){
        return new CustomLinkedListImplIterator();
    }

    private class CustomLinkedListImplIterator  implements Iterator<AnyType>{
        private Node<AnyType> nextNode;

        public CustomLinkedListImplIterator(){
            nextNode = head;
        }

        public boolean hasNext(){
            return nextNode != null;
        }

        public AnyType next(){
            if (!hasNext()) throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() { throw new UnsupportedOperationException(); }
    }



    /*****   Include the main() for testing and debugging  *****/


    public static void main(String[] args){
        CustomLinkedListImpl<String> list = new CustomLinkedListImpl <String>();
        list.addFirst("p");
        list.addFirst("a");
        list.addFirst("e");
        list.addFirst("h");
        System.out.println(list);
        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,8,9,89,88);
        System.out.println(numbers.stream()
                .map(e -> e * 2)
                .reduce(0, (c,e) -> c + e));
        CustomLinkedListImpl<String> twin = list.copy3();
        System.out.println(twin);

        System.out.println(list.get(0));
//		System.out.println(list.get(4));   //exception

        list.addLast("s");
        Iterator itr = list.iterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();


        /*for(Object x : list)
            System.out.print(x + " ");
        System.out.println();*/
        list.forEach(System.out::println);

        list.insertAfter("e", "ee");
        System.out.println(list);
        System.out.println(list.getLast());

        list.insertBefore("h", "yy");
        System.out.println(list);

        list.remove("p");
        System.out.println(list);
    }
}