package com.lijian.effectivejava.demo.serviceloader;

public class HipHop implements Dance{

    @Override
    public String getName() {
        return "HipHop";
    }

    @Override
    public void printDescription() {
        System.out.println("what's up man, this's HipHop");
    }
}
