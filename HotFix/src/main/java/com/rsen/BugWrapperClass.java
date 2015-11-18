package com.rsen;

/**
 * Created by angcyo on 15-11-18-018.
 */
public class BugWrapperClass {
    public String getBug() {
        return new BugClass().getBug();
    }
}
