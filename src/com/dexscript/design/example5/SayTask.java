package com.dexscript.design.example5;

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Task;

public class SayTask extends Task {

    protected SayTask(Scheduler scheduler, World callee) {
        super(scheduler, callee);
        callee.say(this);
    }
}
