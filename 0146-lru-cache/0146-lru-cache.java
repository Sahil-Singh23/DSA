//doubly linked list

//this is solved using doubley linked list n hashmap 
class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val){
        this.val = val;
        this.key = key;
    }
}
class LRUCache {
    Map<Integer,Node> hm;
    Node head;
    Node tail;
    int maxCap;
    int size;
    public LRUCache(int capacity) {
        this.maxCap = capacity;
        this.size = 0;
        this.hm = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next =tail;
        this.tail.prev= head;
    }
    
    public int get(int key) {
        //get the element at the given key, n place it after head 
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            int val = node.val;
            // Remove node from its current position
            remove(node);

            // Insert node right after head
            insertAtHead(node);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //add the element 
        //if key already there update val n get in front, 
        
        if(hm.containsKey(key)){
            Node cur = hm.get(key);
            cur.val = value;
            remove(cur);
            insertAtHead(cur);
        }else{
            //here we add , n if size exceeds we kick the last one , 
            if(hm.size() == maxCap){
                Node lru = tail.prev;
                hm.remove(lru.key);
                remove(lru);
            }
            Node newNode = new Node(key,value);
            hm.put(key,newNode);
            insertAtHead(newNode);

        }
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertAtHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */