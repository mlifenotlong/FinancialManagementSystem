package com.cj.userModule.vo;

import java.util.ArrayList;
import java.util.List;

public class tt {
    int head ;

    public tt( List<Integer> list) {
        this.head = -1;
        this.tail = -1;
        this.list = list;
    }

    int tail;

    List<Integer> list;
    public Integer get() {
        head++;
        System.out.println(head);
        return list.get(head);
    }

    public Integer put(int t) {

        tail++;
        list.add(t);
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> ttt=new ArrayList<>();

        tt tt=new tt(ttt);
        System.out.println(tt.put(123));
        tt.put(321);
        System.out.println(tt.get());
        System.out.println(tt.get());
    }
}
