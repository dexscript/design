package com.dexscript.design.example5;

/*
import System.out.println

def Hello() {
    System.out.println('hello')
    world := World{}
    println(world.say())
}
def World() {
    await {
    -> say(task Task{String}) {
        yield()
        task.reply('world')
    }}
}
*/

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class Hello extends Actor {

    private final SayTask sayTask;

    protected Hello(Scheduler scheduler) {
        super("hello", scheduler);
        System.out.println("hello");
        World world = new World(scheduler);
        sayTask = new SayTask(scheduler, world);
        if (sayTask.result() == null) {
            sayTask.await(this);
        } else {
            onSayTask();
        }
    }

    @Override
    protected void resume() {
        for (Actor response : fetchResponses()) {
            if (response.equals(sayTask)) {
                onSayTask();
                return;
            }
        }
    }

    private void onSayTask() {
        System.out.println(sayTask.result()[0]);
        finish();
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        new Hello(scheduler);
        scheduler.schedule();
    }
}
