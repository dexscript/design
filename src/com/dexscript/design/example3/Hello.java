package com.dexscript.design.example3;

/*
import System.out.println

def Hello() {
    System.out.println('hello')
    world1 := World{'world1'}
    world2 := World{'world2'}
    await {
        msg := <- world1 {
            println(msg)
        }
        msg := <- world2 {
            println(msg)
        }
    }
}
def World(msg String): String {
    yield()
    return msg
}
*/

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class Hello extends Actor {

    private final World world1;
    private final World world2;

    protected Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("hello");
        world1 = new World(scheduler, "world1");
        world2 = new World(scheduler, "world2");
        if (world1.result() == null) {
            world1.await(this);
        } else {
            onWorld1();
            return;
        }
        if (world2.result() == null) {
            world2.await(this);
        } else {
            onWorld2();
            return;
        }
    }

    @Override
    protected void resume() {
        for (Actor response : fetchResponses()) {
            if (response.equals(world1)) {
                onWorld1();
                return;
            }
            if (response.equals(world2)) {
                onWorld2();
                return;
            }
        }
    }

    private void onWorld1() {
        System.out.println(world1.result()[0]);
        finish();
    }

    private void onWorld2() {
        System.out.println(world2.result()[0]);
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        new Hello(scheduler);
        scheduler.schedule();
    }
}
