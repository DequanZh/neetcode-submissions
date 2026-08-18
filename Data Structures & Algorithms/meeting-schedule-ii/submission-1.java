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
    public int minMeetingRooms(List<Interval> intervals) {
        //[0,5,15]
        //[10,20,40]
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for(Interval interval : intervals){
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);
        int i = 0, j = 0, rooms = 0, roomsNeeded = 0;
        while(i < start.size() && j < end.size()){
            if(start.get(i) < end.get(j)){
                i++;
                rooms++;
            }else{
                rooms--;
                j++;
            }
            roomsNeeded = Math.max(rooms,roomsNeeded);
        }
        return roomsNeeded;
    }
}
