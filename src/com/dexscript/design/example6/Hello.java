package com.dexscript.design.example6;

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

/*
import System.out.println

def Hello() {
    println('step1')
    yield()
    println('step2')
    yield()
    println('step3')
}
 */
public class Hello extends Actor {

    protected Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("step1");
        yield();
    }

    @Override
    public void resume() {
        switch (state) {
            case 0:
                onState0();
                break;
            case 1:
                onState1();
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private void onState0() {
        System.out.println("step2");
        state = 1;
        yield();
    }

    private void onState1() {
        System.out.println("step3");
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        new Hello(scheduler);
        scheduler.schedule();
    }
}
