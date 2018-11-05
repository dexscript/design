package com.dexscript.design.example1;

/*
import System.out.println

def Hello() {
    println("hello")
}
*/

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

public final class Hello extends Actor {

    public Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("hello");
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Hello hello = new Hello(scheduler);
        scheduler.schedule();
    }
}
