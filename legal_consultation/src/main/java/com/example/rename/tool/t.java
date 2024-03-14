package com.example.rename.tool;

public class t {
    static int num=4;
    {
        int t=1;
        System.out.println("b");
    }
    int g=1;
    {
        System.out.println("d");
    }
    t(){
        System.out.println("a");
    }
    static {
        System.out.println("c");
    }

    public static void main(String[] args) {
        t t=new t();

    }
}
