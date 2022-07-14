import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new LinkedList<Interval>();
    boolean check[] = new boolean[intervals.size()];
    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    for(int i = 0; i<intervals.size(); i++){
      if(check[i]){
        continue;
      }
      else{
        Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
        int j = i+1;
        while(j<intervals.size()){
          int x1 = temp.start;
          int y1 = temp.end;
          int x2 = intervals.get(j).start;
          int y2 = intervals.get(j).end;
          if(check[j] == true){
            j++;
            continue;
          }

          if(x1 <= x2 && y1>= x2){
            temp.start = x1;
            temp.end = Math.max(y1,y2);
            check[j] = true;
            j++;
          }
          else{
            j++;
          }
        }
        mergedIntervals.add(temp);
      }
    }

    // TODO: Write your code here
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
