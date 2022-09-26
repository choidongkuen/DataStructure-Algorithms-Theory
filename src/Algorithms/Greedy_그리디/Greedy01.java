// n개의 활동과 각 활동의 시작/종료 시간이 주어졌을 때
// 한 사람이 최대한 많이 할 수 있는 활동의 수 구하기

package Algorithms.Greedy_그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Activity{

    String name;
    int start;
    int end;

    Activity(String name, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
    }
    public void showData(){
        System.out.println("name = " + name);
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        System.out.println("============");
    }
}

public class Greedy01 {

    public static void selectActivity(ArrayList<Activity> list){

        Collections.sort(list, (x1,x2) -> x1.end - x2.end); // 종료시간 기준 오름차순 정렬

        int curTime = 0; // 종료 시간
        ArrayList<Activity> result = new ArrayList<>(); // 결과를 위한 배열리스트

        for(Activity a : list){

            if(a.start >= curTime){
                curTime = a.end;
                result.add(new Activity(a.name,a.start, a.end));
            } // 들을 수 있는 경우
        }

        for(Activity a: result)
            a.showData();
    }
    public static void main(String[] args) {

        ArrayList<Activity> arrList = new ArrayList<>();
        arrList.add(new Activity("A",1,5));
        arrList.add(new Activity("B",4,5));
        arrList.add(new Activity("C",2,3));
        arrList.add(new Activity("D",4,7));
        arrList.add(new Activity("E",6,10));

        selectActivity(arrList);
    }
}
