package com.abirfaisal.stackHeapExample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abirfaisal on 5/20/15.
 */
public class QueueDemo {

    public static void main(String[] args){
        Queue q1 = new LinkedList();
        q1.add("A");
        q1.add("B");
        q1.add("C");

        System.out.println(q1.remove());
        System.out.println(q1.remove());
        System.out.println(q1.remove());

    }
}
