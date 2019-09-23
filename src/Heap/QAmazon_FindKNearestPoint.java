package Heap;

import java.util.*;

public class QAmazon_FindKNearestPoint {

    public static void main(String[] args){
        QAmazon_FindKNearestPoint a=new QAmazon_FindKNearestPoint();
        Point [] ans=a.findK(new Point[]{new Point(1,2),new Point(2,3),new Point(3,4),
        new Point(6,7),new Point(1,5),new Point(3,6)},new Point(5,2),3);
        for (Point p:ans){
            System.out.println(p.x);
            System.out.println(p.y);
            System.out.println("----");
        }
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public Point [] findK (Point [] array, Point origin, int K){

//        Arrays.sort(array,Comparator.comparing(p->Math.pow(p.x-origin.x,2)+Math.pow(p.y-origin.y,2)));
//        return Arrays.copyOfRange(array,0,K);
        Point [] ans=new Point[K];
        PriorityQueue<Point> pq=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return getdist(p1,origin)-getdist(p2,origin);
            }
        });
        for (Point p: array){
            if (pq.size()>=K)
                pq.poll();
            pq.add(p);
        }
        for (int i=0;i<K;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }

    public int getdist(Point p1,Point p2){
        return (int)(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }
}
