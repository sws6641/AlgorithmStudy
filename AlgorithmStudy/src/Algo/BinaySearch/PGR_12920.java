package Algo.BinaySearch;

//    https://rays-space.tistory.com/15
public class PGR_12920 {
    class Solution {
        public int solution(int n, int[] cores) {
            int answer = 0;

            int min = 0; // 시간의 최소값
            int max = cores[0]*n; // 시간의 최대값

            int time = 0;
            int m = 0; // time까지 처리한 작업량

            while(min <= max) {
                int mid = (min+max) / 2;

                int count = CountWork(mid, cores);

                if(count >= n) {
                    max = mid - 1;
                    time = mid;
                    m = count;
                }
                else{
                    min = mid + 1;
                }
            }

            m -= n; // 처리한 작업량과 n의 차이 갱신

            for(int i = cores.length-1 ; i >= 0 ; i --){
                if(time % cores[i] == 0) {
                    if(m == 0) {
                        answer = i + 1;
                        break;
                    }
                    m--;
                }
            }

            return answer;
        }

        public int CountWork(int time, int[] cores) {
            if(time == 0) {
                return cores.length;
            }

            int count = cores.length;

            for(int i = 0 ; i < cores.length ; i++){
                count += (time/cores[i]);
            }

            return count;
        }
    }
}




//// 우선순위큐
//class Solution {
//    static class Node implements Comparable<Node> {
//        int idx;
//        int time;
//
//        Node (int idx, int time) {
//            this.idx = idx;
//            this.time = time;
//        }
//
//        public int compareTo(Node n) {
//            if(this.time == n.time) {
//                return this.idx - n.idx;
//            }
//            return this.time - n.time;
//        }
//    }
//
//    public int solution(int n, int[] cores) {
//        int answer = 0;
//
//        if(n <= cores.length) return n;
//
//        n -= cores.length;
//
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//
//        for(int i = 0 ; i < cores.length ; i++) {
//            pq.offer(new Node(i, cores[i]));
//        }
//
//        int time = 1;
//        while(n > 0) {
//            Node now = pq.poll();
//
//            if(now.time == time) {
//                n--;
//            }
//            else if(now.time > time) {
//                time = now.time;
//                n--;
//            }
//
//            if(n == 0) {
//                answer = now.idx + 1;
//            }
//            else {
//                System.out.print(now.idx + " ");
//                System.out.println(time + cores[now.idx]);
//                pq.offer(new Node(now.idx, time + cores[now.idx]));
//            }
//        }
//
//        return answer;
//    }
//}
