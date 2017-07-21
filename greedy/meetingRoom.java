package greedy;
import java.util.*;
/*
*  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
   For example,
    Given [[0, 30],[5, 10],[15, 20]],
    return 2.
*  
*/
public class meetingRoom {
	
 //Definition for an interval.
  public class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
 
  public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals.length==0) return 0;
        
        //sort in ascending order of start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){return i1.start-i2.start;}
            });
            
        //for(Interval i: intervals)
        //    System.out.println(i.start);
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {return i1.end-i2.end;} 
        });
        
        //init pq
        pq.offer(intervals[0]);
        
        for(int i=1; i<intervals.length; i++) {
            Interval curr = pq.poll();
            //merge intervals
            if(intervals[i].start>=curr.end) {
                curr.end = intervals[i].end;
            }
            else {
                pq.offer(intervals[i]);
            }
            //offer the original one. it could be merged or previous non-merge from pq
            pq.offer(curr);
        }
        return pq.size();
    }
	

}
