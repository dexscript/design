package com.dexscript.design.example5;

import com.dexscript.design.core.Actor;
import com.dexscript.design.core.Scheduler;

public class SayTask extends Actor {

    private World callee;

    protected SayTask(Scheduler scheduler, World callee) {
        super(scheduler);
        this.callee = callee;
        callee.say(this);
    }

    public void resolve(String result) {
        System.out.println("resolve: " + callee + " => " + this);
        finish(result);
    }
}
