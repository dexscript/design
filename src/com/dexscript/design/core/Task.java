package com.dexscript.design.core;

public class Task extends Actor {

    private Actor callee;

    protected Task(Scheduler scheduler, Actor callee) {
        super(scheduler);
        this.callee = callee;
    }

    public void reply(Object... result) {
        System.out.println("reply: " + callee + " => " + this);
        finish(result);
    }
}
