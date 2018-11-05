package com.dexscript.design.example4;

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class World extends Actor {

    protected World(Scheduler scheduler) {
        super("world", scheduler);
    }

    public String say() {
        if (state != 0) {
            throw new IllegalStateException();
        }
        finish();
        return "world";
    }
}
