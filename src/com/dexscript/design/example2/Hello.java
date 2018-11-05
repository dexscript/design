package com.dexscript.design.example2;

/*
import System.out.println

def Hello() {
    println('hello')
    println(World())
}
def World() {
    return 'world'
}
*/

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

public final class Hello extends Actor {

    private final World world;

    public Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("hello");
        world = new World(scheduler);
        if (world.result() == null) {
            world.await(this);
        } else {
            onWorld();
        }
    }

    @Override
    protected void resume() {
        switch (state) {
            case 0:
                onState0();
            default:
                throw new IllegalStateException();
        }
    }

    private void onState0() {
        for (Actor response : fetchResponses()) {
            if (response.equals(world)) {
                onWorld();
                return;
            }
        }
    }

    private void onWorld() {
        System.out.println(world.result()[0]);
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        new Hello(scheduler);
        scheduler.schedule();
    }
}
