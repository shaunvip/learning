package arr;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static void main(String[] args) {
       String[] words={"i","love","leetcode","i","love","coding"};
        List<String> ss=topKFrequent(words,2);
        ss.forEach(System.out::println);
    }
    public  static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordCount=new HashMap<String,Integer>();
        for(String s:words){
            wordCount.put(s,wordCount.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq= new PriorityQueue<>((s1, s2) -> {
            {
                int w1 = wordCount.get(s1);
                int w2 = wordCount.get(s2);
                if (w1 == w2) return s2.compareTo(s1);
                return w1 - w2;
            }
        });
        for (String w:wordCount.keySet()){
            pq.offer(w);
            if (pq.size()>k) pq.poll();
        }
        return new ArrayList<>(pq);
    }
}
