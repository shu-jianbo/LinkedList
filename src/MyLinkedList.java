public class MyLinkedList {
    // size是存储链表元素的个数
    int size;
    // 虚拟头结点
    ListNode head;

    // 无参构造方法初始化链表
    public MyLinkedList() {
        // 初始化好size=0，数据值val=0的链表，head是头结点
        size = 0;
        head = new ListNode(0);
    }

    /*
    定义链表的实现方法
    1. get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    2. addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    3. addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    4. addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
    5. deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    提示：所有val值都在 [1, 1000] 之内。
         操作次数将在  [1, 1000] 之内。
         请不要使用内置的 LinkedList 库。
     */
    // 获取链表第index个节点的值


    /*
         public MyLinkedList() {
            // 初始化好size=0，数据值val=0的链表，head是头结点
            size = 0;
            head = new ListNode(0);
        }
        从MyLinkedList的定义我们可以知道，头节点是不计入size中的
     */
    public int get(int index) {
        // 如果index不在索引范围内，返回-1
        if (index < 0 || index >= size) {
            System.out.println("index不在索引范围内，请重新输入");
            return -1;
        }
        ListNode currentNode = head; // 从头开始遍历，currentNode相当于指针
        // 遍历链表取值
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next; //往前遍历节点
        }
        return currentNode.val;
    }
    //  addAtIndex(index,val)
    public ListNode addAtIndex(int index, int val) {
        //index大于链表长度
        if (index > size) {
            return head;
        }
        // 在头部节点或者头节点之前
        if (index <= 0) {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            size++;
            head = newHead;   // 将新的头部节点定义为节点
            return head;
        }
        // index等于链表的长度，添加节点至末尾
        ListNode currentNode = head;
        ListNode addNode = new ListNode(val);
        if (index == size) {
            for (int i=0;i<size;i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = addNode;
            addNode.next = null;
            size++;
            return head;
        }
        ListNode currentNode2 = head; //定义变量遍历，起到指针的作用
        for (int i = 0; i < index; i++) {
            currentNode2 = currentNode2.next;
        }
        currentNode2.next = addNode; // 两条连起来
        addNode.next = currentNode.next; //
        size++;
        return head;
    }
    // 在链表的第一个元素之前插入一个值为val的节点
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    // addTail(val)
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    // deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public ListNode deleteAtIndex(int index) {
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode.next = currentNode;
        }
        currentNode.next = currentNode.next.next;
        size--;
        return head;
    }

    //    public void list(ListNode head) {
//        // 判断链表是否为空
//        if (head.next == null) {
//            System.out.println("链表为空");
//            return;
//        }
//        ListNode currentNode = head; // 定义一个变量指向head然后进行遍历
//        for (int i = 1; i < size; i++) {
//            System.out.println(currentNode.val);
//            currentNode = currentNode.next; //往前遍历
//        }
//    }
    public static void printList(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NULL");
    }
}
