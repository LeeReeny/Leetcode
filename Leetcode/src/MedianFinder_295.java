import java.util.PriorityQueue;

public class MedianFinder_295 {
    public class MedianFinder{
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;
        public MedianFinder(){
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b-a);
        }

        public void addNum(int num){
            max.add(num);
            min.add(max.remove());
            if(min.size() > max.size()) max.add(min.remove());
        }

        public double findMedian(){
            if(max.size() == min.size()) return (max.peek() + min.peek())/2.0;
            else return max.peek();
        }
    }
}
