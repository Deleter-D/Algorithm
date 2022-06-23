class MyLinkedList {

    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode();
        size = 0;
    }


    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode pointer = head;
        for (int i = 0; i < index + 1; i++) {
            pointer = pointer.next;
        }
        return pointer.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        ListNode pointer = head;
        while (pointer.next != null)
            pointer = pointer.next;
        ListNode node = new ListNode(val);
        pointer.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) this.addAtHead(val);
        else if (index == size) this.addAtTail(val);
        else if (index > size) return;
        else {
            ListNode pointer = head;
            for (int i = 0; i < index; i++) {
                pointer = pointer.next;
            }
            ListNode node = new ListNode(val);
            node.next = pointer.next;
            pointer.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        size--;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}