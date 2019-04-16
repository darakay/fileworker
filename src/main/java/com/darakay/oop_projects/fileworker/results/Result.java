package com.darakay.oop_projects.fileworker.results;

public class Result<T> {
    private T inner;

    public Result(T inner) {
        this.inner = inner;
    }

    public String print(){
        return String.format("Result: %s", inner);
    }
}
