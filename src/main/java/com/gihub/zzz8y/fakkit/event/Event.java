package com.gihub.zzz8y.fakkit.event;

public abstract class Event {
    private String name;

    public abstract HandlerList getHandlers();
}
