package com.dexscript.design.example2;

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

public class World extends Actor {

    protected World(Scheduler scheduler) {
        super("world", scheduler);
        finish("world");
    }
}
