package com.dexscript.design.core;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Actor> readyActors = new ArrayList<>();

    public final void schedule() {
        while (!this.readyActors.isEmpty()) {
            List<Actor> todoActors = this.readyActors;
            readyActors = new ArrayList<>();
            for (Actor todoActor : todoActors) {
                todoActor.resume();
            }
        }
    }

    final void wakeUp(Actor wakeUpFrom, Actor target) {
        System.out.println("wake up: " + wakeUpFrom + " => " + target);
        readyActors.add(target);
    }
}
