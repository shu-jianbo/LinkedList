public class MyLinkedListDemo {

    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.head.next = new ListNode(20);  //这样添加size并没有增加1
        myLinkedList.addAtHead( 10);
        myLinkedList.addAtTail(20);
        myLinkedList.addAtIndex(2, 9);
        myLinkedList.addAtIndex(12, 12);
        MyLinkedList.printList(myLinkedList.head);
        System.out.println();
        System.out.println(myLinkedList.get(2));
    }
}


