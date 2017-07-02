/*
 * LC 432 all O(1) operation
 */

import java.util.*;

public class AllOne {
	
	class Bucket {
        private int cnt;
        private Bucket prev, next;
        private HashSet<String> keySet;
        
        public Bucket(int count) {
            cnt = count;
            next= null;
            prev = null;
            keySet = new HashSet<>();
        }
        
    }
    
    private HashMap<String, Integer> cntMap;
    private HashMap<Integer, Bucket> bucketMap;
    private Bucket head, tail;
    
    /** Initialize your data structure here. */
    public AllOne() {
        cntMap = new HashMap<>();
        bucketMap = new HashMap<>();
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	  if(cntMap.containsKey(key)==true) {
              updateKey(key, 1);
          }
          else {
              // check if bucket 1 exsits or not
              cntMap.put(key, 1);
              if(head.next.cnt!=1)
                  addBucket(new Bucket(1), head);
              
              bucketMap.put(1, head.next);
              head.next.keySet.add(key);
              
          }
          
         return; 
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int count = cntMap.get(key);
        
        if(count==1) {
            removeKeyFromBucket(key);
            cntMap.remove(key);
        }
        else {
            updateKey(key, -1);   
        }
        return;
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev==head?"":tail.prev.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next==tail?"":head.next.keySet.iterator().next();
    }
    //update key
    public void updateKey(String key, int val) {
        int count = cntMap.get(key);
        Bucket cur = bucketMap.get(count);
        
        if(count+val>0) {
            Bucket newBucket = bucketMap.get(count+val);
            
            if(newBucket==null) 
                newBucket = new Bucket(count+val);    
            //add newBucket to doubly linked list
            addBucket(newBucket, val==1?cur:cur.prev);
            bucketMap.put(count+val, newBucket);
        }
        removeKeyFromBucket(key);
        cntMap.put(key, count+val);
       
        return;
    }
    
    public void removeKeyFromBucket(String key) {
        int count = cntMap.get(key);
        Bucket b = bucketMap.get(count);
        
        b.keySet.remove(key);
        
        if(b.keySet.size()==0) {
            b.next.prev = b.prev;
            b.prev.next = b.next;
            b.next = null;
            b.prev=null;
            bucketMap.remove(b.cnt);
        }
        return;    
    }
    // 
    public void addBucket(Bucket newBucket, Bucket insertBucket) {
        newBucket.next = insertBucket.next;
        newBucket.prev = insertBucket;
        insertBucket.next.prev = newBucket;
        insertBucket.next= newBucket;
        return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllOne obj = new AllOne();
		
		obj.inc("A");
		obj.inc("A");
		System.out.println("max " +obj.getMaxKey() + " min " + obj.getMinKey());
		//System.out.println("exit");
	}

}
