/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (i1,i2)-> {return i1.end - i2.end;});
        int i = 1;
        while(i < intervals.size()){
            if(intervals.get(i-1).end > intervals.get(i).start){
                return false;
            }
            i++;
        }
        return true;
    }
}
