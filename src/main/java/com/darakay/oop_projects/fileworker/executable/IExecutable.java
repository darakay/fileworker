package com.darakay.oop_projects.fileworker.executable;

import com.darakay.oop_projects.fileworker.results.Result;

import java.io.File;

public interface IExecutable<T> {
    Result<T> procces(File file);
}

