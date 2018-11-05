package com.dexscript.design.example2;

/*
def Hello() {
    System.out.println('hello')
    System.out.println(World())
}
def World() {
    return 'world'
}
*/

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

//public final class Hello extends Actor {
//
//    public Hello(Scheduler scheduler, Actor caller) {
//        super("hello", scheduler, caller);
//        System.out.println("hello");
//        next = this::world;
//        new World(scheduler, this);
//    }
//
//    private void world() {
//        System.out.println("!");
//        finish(null);
//    }
//
//    public static void main(String[] args) {
//        Scheduler scheduler = new Scheduler();
//        new Hello(scheduler, null);
//        scheduler.schedule();
//    }
//}
