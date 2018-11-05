package com.dexscript.design.example3;

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class World extends Actor {

    private String msg;

    protected World(Scheduler scheduler, String msg) {
        super("world", scheduler);
        this.msg = msg;
        yield();
    }

    @Override
    protected void resume() {
        finish(msg);
    }
}
