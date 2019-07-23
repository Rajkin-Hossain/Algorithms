public class LinkedListCycle {
    public ListNode detectCycle(ListNode a) {
        
    	// DO NOT USE UNNECESSARY RECURSION
    	
        while(a != null) {
        	
        	// a == a.next thats how can be checked..
            if(a.next != null && a == a.next){
                return a;
            }
            
            ListNode next = a.next;
            
            a.next = a;
            
            a = next;
        }
        
        return null;
    }
    
    class ListNode {
    	 public int val;
    	 public ListNode next;
    	 
    	 ListNode(int x) { 
    		 val = x; next = null; 
    	 }
    }
}