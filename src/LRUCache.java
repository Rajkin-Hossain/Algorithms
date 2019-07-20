import java.util.HashMap;

public class LRUCache {
    
    HashMap<Integer, Pair> hash;
    Node head, tail;
    int cap;
    
    public LRUCache(int capacity) {
        hash = new HashMap<>();
        head = tail = null;
        cap = capacity;
    }
    
    public int get(int key) {
        int returnValue = -1;
        
        if(hash.containsKey(key)){
            
            Pair pair = hash.get(key);
            returnValue = pair.value;
            
            Node ref = pair.ref;
            
            if(ref.key == head.key && head.key == tail.key){
                return returnValue;
            }
            else if(ref.key == tail.key){
                return returnValue;
            }
            else if(ref.key == head.key){
                Node refNewNode = new Node(ref.key);
                
                tail.next = refNewNode;
                refNewNode.prev = tail;
                tail = refNewNode;
                
                head = head.next;
                head.prev = null;
                
                hash.put(ref.key, new Pair(refNewNode, returnValue));
                
                return returnValue;
            }
            else {
                
                ref.prev.next = ref.next;
                ref.next.prev = ref.prev;
                
                tail.next = ref;
                ref.prev = tail;
                tail = ref;
                
                return returnValue;
            }
        }
        
        return returnValue;
    }
    
    public void set(int key, int value) {
        if(hash.containsKey(key)){
            // remove it
            Pair p = hash.get(key);
            
            if(key == head.key){
                head = head.next;
                if(head != null) head.prev = null;
            }
            else if(key == tail.key){
                tail.prev.next = null;
                tail = tail.prev;
            }
            else{
                Node ref = p.ref;
                
                ref.prev.next = ref.next;
                ref.next.prev = ref.prev;
            }
        }
        
        Node newNode = new Node(key);
        
        hash.put(key, new Pair(newNode, value));
        
        if(head == null){
            head = tail = newNode;
            
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        
        if(hash.size() > cap){
            hash.remove(head.key);
            
            head = head.next;
            head.prev = null;
        }
    }
    
    class Pair {
        Node ref;
        int value;
        
        public Pair(Node ref, int value){
            this.ref = ref;
            this.value = value;
        }
    }
    
    class Node {
        Node next, prev;
        int key;
        
        public Node(int key){
            this.key = key;
        }
    }
}
