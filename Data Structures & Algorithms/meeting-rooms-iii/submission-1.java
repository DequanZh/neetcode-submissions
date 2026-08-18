class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> rooms = new PriorityQueue<>((r1,r2)->{
            return r1-r2;
        });
        Map<Integer,Integer> useCountMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            rooms.offer(i);
            useCountMap.put(i,0);
        }
        //[room number, start, end time]
        PriorityQueue<int[]> meetingQueue = new PriorityQueue<>((r1,r2)->{
            if(r1[2] == r2[2]){ // same end time, sort based on start
                return r1[0] - r2[0];
            }
            return r1[2]-r2[2];
        });
        Arrays.sort(meetings,(m1,m2)->{
            return m1[0] - m2[0];
        });
        for(int[] meeting : meetings){
            int start = meeting[0], end = meeting[1];
            while(!meetingQueue.isEmpty() && meetingQueue.peek()[2] <= start){
                int[] meetingDone = meetingQueue.poll();
                rooms.add(meetingDone[0]);
            }
            if(rooms.isEmpty()){ // No avaliable rooms
                int duration = end - start;
                int[] curMeeting = meetingQueue.poll();
                int roomNumber = curMeeting[0];
                int endTime = curMeeting[2];
                meetingQueue.offer(new int[]{roomNumber, endTime, endTime + duration});
                //Increment count;
                useCountMap.put(roomNumber, useCountMap.get(roomNumber)+1);
            }else{
                int nextRoom = rooms.poll();
                meetingQueue.offer(new int[]{nextRoom, start, end});
                useCountMap.put(nextRoom, useCountMap.get(nextRoom)+1);
            }
        }
        int maxMeetingRoom = 0;
        for(int i = 0; i < n; i++){
            if(useCountMap.get(maxMeetingRoom) < useCountMap.get(i)){
                maxMeetingRoom = i;
            }
        }
        return maxMeetingRoom;
    }
}