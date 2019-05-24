public class Treap {
	
    Node root;
	
    int length;
    int g_seed;
    int ans;
 
    long lowerValue, higherValue;
    long ceilValue, floorValue;
       
    public Treap(){
        g_seed = 1;
        length = 0;
           
        lowerValue = higherValue = -1;
        ceilValue = floorValue = -1;
    }
       
    int fastrand() {
        g_seed = (214013 * g_seed + 2531011);
        
        return (g_seed>>16) & 0x7FFF;
    }
       
    int getSize(Node cursor){
        if(cursor == null) return 0;
        
        int leftSubTreeSize = cursor.left != null ? cursor.left.size : 0;
        int rightSubTreeSize = cursor.right != null ? cursor.right.size : 0;
       
        return 1 + leftSubTreeSize + rightSubTreeSize;
    }
       
    Node rotateRight(Node cursor){
        Node returedNode = cursor.left;
       
        Node z = cursor.left.right;
        cursor.left.right = cursor;
        cursor.left = z;
       
        return returedNode;
    }
   
    Node rotateLeft(Node cursor){
        Node returedNode = cursor.right;
       
        Node z = cursor.right.left;
        cursor.right.left = cursor;
        cursor.right = z;
       
        return returedNode;
    }
       
    Node insert(Node cursor, long value){
        if(cursor == null) {
            return new Node(value);
        }
       
        if(value < cursor.value){
            cursor.left = insert(cursor.left, value);
           
            if(cursor.left.priority > cursor.priority){
                cursor = rotateRight(cursor);
            }
        }
        else{
            cursor.right = insert(cursor.right, value);
           
            if(cursor.right.priority > cursor.priority){
                cursor = rotateLeft(cursor);
            }
        }
       
        if(cursor.left != null) cursor.left.size = getSize(cursor.left);
        if(cursor.right != null) cursor.right.size = getSize(cursor.right);
       
        cursor.size = getSize(cursor);
       
        return cursor;
    }
        
    void insert(long value){
        root = insert(root, value);
        length++;
    }
   
    boolean isFound(Node cursor, long value){
        if(cursor == null) return false;
       
        if(value < cursor.value){
            return isFound(cursor.left, value);
        }
        else if(value == cursor.value){
            return true;
        }
        else{
            return isFound(cursor.right, value);
        }
    }
   
    boolean isFound(long value){
        return isFound(root, value);
    }
   
    Node delete(Node cursor, long key) {
        if (cursor == null) return cursor;
       
        if (key < cursor.value) {
            cursor.left = delete(cursor.left, key);
        }
        else if (key > cursor.value) {
            cursor.right = delete(cursor.right, key);
        }
        else if (cursor.left == null) {
            cursor = cursor.right;
        }
        else if (cursor.right == null) {
            cursor = cursor.left;
        }
        else if (cursor.left.priority < cursor.right.priority){
            cursor = rotateLeft(cursor);
            cursor.left = delete(cursor.left, key);
        }
        else {
            cursor = rotateRight(cursor);
            cursor.right = delete(cursor.right, key);
        }
       
        if(cursor != null) {
            if(cursor.left != null) cursor.left.size = getSize(cursor.left);
            if(cursor.right != null) cursor.right.size = getSize(cursor.right);
           
            cursor.size = getSize(cursor);
        }
     
        return cursor;
    }
       
    void delete(long key){
        root = delete(root, key);
        length--;
    }
       
    Node getKth(Node temp, int par, int k){
      	if(temp == null) return null;
            
    	int currSize = par + getSize(temp.left) + 1;
        if(currSize == k) return temp;
 
        else if(currSize <= k) return getKth(temp.right, currSize, k);
        else return getKth(temp.left, par, k);
    }
       
    long getKth(int k){
        if(k > length) return -1;
        return getKth(root, 0, k).value;
    }
   
    void higher(Node cursor, long key){
        if(cursor == null) return;
       
        if(key < cursor.value){
            higherValue = cursor.value;
            higher(cursor.left, key);
        }
        else{
            higher(cursor.right, key);
        }
    }
   
    void higher(long key){
        higherValue = -1l;
        higher(root, key);
    }
   
    void ceil(Node cursor, long key){
        if(cursor == null) return;
       
        if(key < cursor.value){
            ceilValue = cursor.value;
            ceil(cursor.left, key);
        }
        else if(key == cursor.value){
            ceilValue = cursor.value;
        }
        else{
            ceil(cursor.right, key);
        }
    }
   
    void ceil(long key){
        ceilValue = -1l;
        ceil(root, key);
    }
       
    void floor(Node cursor, long key){
        if(cursor == null) return;
       
        if(key > cursor.value){
            floorValue = cursor.value;
            floor(cursor.right, key);
        }
        else if(key == cursor.value){
            floorValue = cursor.value;
        }
        else{
            floor(cursor.left, key);
        }
    }
   
    void floor(long key){
        floorValue = -1l;
        floor(root, key);
    }
   
    void lower(Node cursor, long key){
        if(cursor == null) return;
       
        if(key > cursor.value){
            lowerValue = cursor.value;
            lower(cursor.right, key);
        }
        else{
            lower(cursor.left, key);
        }
    }
   
    void lower(long key){
        lowerValue = -1l;
        lower(root, key);
    }
    
    int getIndex(Node cursor, long key){
        if(cursor == null) return 0;
        
        if(key > cursor.value){
            return getSize(cursor.left) + 1 + getIndex(cursor.right, key);
        }
        else{
            return getIndex(cursor.left, key);
        }
    }
    
    int getIndex(long key){
        return getIndex(root, key);
    }
       
    void print(Node root) {
        if (root == null)
            return;
        print(root.left);
        System.out.println(root.value);
        print(root.right);
    }
   
    class Node {
        double priority;
        long value;
        int size;
       
        Node left, right;
        public Node(long value){
            this.value = value;
            //this.priority = Math.random();
            this.priority = fastrand();
        }
    }
}
