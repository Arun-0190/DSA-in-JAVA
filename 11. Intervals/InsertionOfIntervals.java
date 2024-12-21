import java.util.LinkedList;

public class InsertionOfIntervals {

    //code for the insertion of intervals and returning without overlapping
    /*
    List<Interval> insert(List<Interval> intervals, Interval newInterval){

        if(intervals == null || intervals.isEmpty())
            return intervals;

        List<Interval> result = new LinkedList<>();
        int i = 0;

        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i));
            i++;

        }

        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){

            Interval current = interval.get(i);
            newInterval.start = Math.min(current.start, newInterval.start);
            newInterval.end = Math.max(current.end, newInterval.end);
            i++;

        }

        result.add(newInterval);
        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;

        }

        return result;

    }
     */

}
