package com.dexscript.design.example4;

/*
import System.out.println

def Hello() {
    System.out.println('hello')
    world := World{}
    println(world.say())
}
def World() {
    await {
    -> say(): String {
        return 'world'
    }}
}
*/

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class Hello extends Actor {

    public Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("hello");
        World world = new World(scheduler);
        System.out.println(world.say());
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        new Hello(scheduler);
        scheduler.schedule();
    }
}
