package com.darakay.oop_projects.fileworker.executable;
import com.darakay.oop_projects.fileworker.results.Result;

import java.io.*;
import java.util.function.Function;

public class HashFunctionExecutor implements IExecutable {
    private Function<String, String> hashFunk;

    public HashFunctionExecutor(Function<String, String> hashFunc){
        this.hashFunk = hashFunc;
    }

    @Override
    public Result procces(File file) {
        String fileInfo = new FileInfo(file).getInfo();
        String hash = hashFunk.apply(fileInfo);
        return new Result(String.format("%s : <%s>", file.getAbsolutePath(), hash));
    }
}
