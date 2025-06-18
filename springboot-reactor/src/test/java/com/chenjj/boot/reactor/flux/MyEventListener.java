package com.chenjj.boot.reactor.flux;

import java.util.List;

public interface MyEventListener<T> {
    void onDataChunk(String event);
    void processComplete();
}
