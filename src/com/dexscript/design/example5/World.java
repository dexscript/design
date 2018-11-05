package com.dexscript.design.example5;

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class World extends Actor {

    private SayTask sayTask;

    protected World(Scheduler scheduler) {
        super("world", scheduler);
    }

    public void say(SayTask sayTask) {
        this.sayTask = sayTask;
        yield();
    }

    public void resume() {
        sayTask.reply("world");
    }
}
