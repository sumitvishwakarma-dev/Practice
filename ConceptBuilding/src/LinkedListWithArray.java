public class LinkedListWithArray {

    public static void main(String[] args){

        int [] arr = {3,6,2,8};
        Node headStart = convertToLL(arr);
        System.out.println("Node value is : "+headStart.next.next.data);

        Node temp = headStart;

        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

   static Node convertToLL(int [] arrPass){
        Node y = new Node(arrPass[0]);
        Node head = y;
        Node mover = head;

        for (int i=1; i <arrPass.length; i++){
            Node temp = new Node(arrPass[i]);
            mover.next = temp;
            mover=temp;
        }
        return head;
    }
}

class Node{

    int data;
    Node next;

    Node(int data){
        this.data= data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}
