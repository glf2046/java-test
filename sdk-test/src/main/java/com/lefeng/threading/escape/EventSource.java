package com.lefeng.threading.escape;

import java.util.HashSet;
import java.util.Set;

public class EventSource {
    private Set<EventListener> listeners = new HashSet<>();
    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void signal(){
        listeners.forEach((listener) -> listener.onEvent(null));
    }
}
