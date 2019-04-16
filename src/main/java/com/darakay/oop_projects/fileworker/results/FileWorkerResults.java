package com.darakay.oop_projects.fileworker.results;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWorkerResults extends ArrayList<Result> {

    public void writeToFile(String fileName){
        try(FileWriter  fw = new FileWriter(fileName)) {
            for(Result result : this)
                fw.write(String.format("%s\n", result.print()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
