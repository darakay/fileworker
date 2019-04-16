package com.darakay.oop_projects.fileworker;

import com.darakay.oop_projects.fileworker.executable.IExecutable;
import com.darakay.oop_projects.fileworker.results.FileWorkerResults;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWorker {
    private final String stringPath;
    private boolean isRecursive;

    public FileWorker(String path) {
        this.stringPath = path;
    }

    public FileWorker recursive(boolean recursive) {
        isRecursive = recursive;
        return this;
    }

    public boolean isRecursive() {
        return isRecursive;
    }

    public FileWorkerResults execute(IExecutable command)
            throws NotDirectoryException, FileNotFoundException {

        Path path = Paths.get(stringPath);
        if(Files.notExists(path)) {
            if(path.toFile().exists())
                throw new NotDirectoryException(path.toString());
            throw new FileNotFoundException();
        }

        return executeForEach(command, Paths.get(stringPath));
    }

    private FileWorkerResults executeForEach(IExecutable command, Path path){
        FileWorkerResults innerResults = new FileWorkerResults();
        for(String fileName : path.toFile().list())
            innerResults.addAll(recursiveExecute(command, path.resolve(Paths.get(fileName))));
        return innerResults;
    }

    private FileWorkerResults recursiveExecute(IExecutable command, Path path) {
        FileWorkerResults results = new FileWorkerResults();
        if(Files.isDirectory(path) && isRecursive)
            results.addAll(executeForEach(command, path));
        results.add(command.procces(path.toFile()));
        return results;
    }
}
