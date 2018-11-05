package com.dexscript.design.example3;

/*
def Hello() {
    System.out.println('hello')
    let world = World{} // detached from caller
    System.out.println(world.say())
}
def World() {
    await {
    -> say(): String {
        return 'world'
    }}
}
*/

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

//public class Hello extends Actor {
//
//    protected Hello(Scheduler scheduler, Actor caller) {
//        super("hello", scheduler, caller);
//        System.out.println("hello");
//        next = this::last;
//        World world = new World(scheduler, null);
//        world.call(this, "say");
//    }
//
//    private void last() {
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
