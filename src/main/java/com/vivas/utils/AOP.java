package com.vivas.utils;

import java.io.PrintStream;

/**
 * Created by duyot on 8/18/2016.
 */
public class AOP {
    private PrintStream stream;

    public AOP(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest() {
        stream.println("Before method");
    }

    public void singAfterQuest() {
        stream.println("After method");
    }
}
