package com.dexscript.design.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Actor {

    // about myself
    private String id;
    private final Scheduler scheduler;
    protected int state;
    // my result, and who to notify
    private List<Actor> resultWaiters;
    // null means computation not done yet
    // to return null, set it to new Object[] { null }
    private Object[] result;
    // notify me here
    private List<Actor> responses;

    protected Actor(String id, Scheduler scheduler) {
        this.id = "actor<" + id + ">";
        this.scheduler = scheduler;
    }

    protected Actor(Scheduler scheduler) {
        this.id = null;
        this.scheduler = scheduler;
    }

    protected String id() {
        if (id == null) {
            id = "actor<" + UUID.randomUUID().toString() + ">";
        }
        return id;
    }

    protected abstract void resume();

    protected final void finish(Object ...result) {
        this.result = result;
        if (resultWaiters == null) {
            return;
        }
        for (Actor resultWaiter : resultWaiters) {
            if (resultWaiter.responses == null) {
                resultWaiter.responses = new ArrayList<>();
            }
            resultWaiter.responses.add(this);
            scheduler.wakeUp(this, resultWaiter);
        }
    }

    protected final void await(Actor waiter) {
        if (resultWaiters == null) {
            resultWaiters = new ArrayList<>();
        }
        resultWaiters.add(waiter);
    }

    protected final Object[] result() {
        return result;
    }

    public String toString() {
        return id();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
