package com.dexscript.design.example3;

import com.dexscript.design.core.Scheduler;
import com.dexscript.design.core.Actor;

//public class World extends Actor {
//
//    protected World(Scheduler scheduler, Actor caller) {
//        super("world", scheduler, caller);
//        next = this::dispatch;
//    }
//
//    private void dispatch() {
//        next = this::last;
//        Request req = serve();
//        switch (req.methodName) {
//            case "say":
//                say(req.caller);
//                break;
//            default:
//                req.caller.reply(this,"unknown method");
//        }
//    }
//
//    private void say(Actor caller) {
//        System.out.println("world");
//        caller.reply(this,"say");
//    }
//
//    private void last() {
//        finish(null);
//    }
//}
