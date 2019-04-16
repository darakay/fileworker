package com.darakay.oop_projects.fileworker.executable;

import java.io.*;

public class FileInfo {
    private final File innerFile;

    public FileInfo(File innerFile) {
        this.innerFile = innerFile;
    }

    public String getInfo() {
        return String.format(
                "Last modified: %s, absolute path: %s, inner: %s,",
                innerFile.lastModified(), innerFile.getAbsolutePath(),
                (innerFile.isDirectory() ? getInnerFileNames() : readFile())

        );
    }

    private String getInnerFileNames() {
        StringBuilder sb = new StringBuilder();
        for(String fileName : innerFile.list())
            sb.append(fileName + ", ");
        return sb.toString();
    }

    private String readFile(){
        StringBuilder sb= new StringBuilder();
        byte[] fileBytes = new byte[(int)innerFile.length()];
        try(InputStream reader = new BufferedInputStream(new FileInputStream(innerFile))) {
            reader.read(fileBytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        for(byte b: fileBytes)
            sb.append(b);
        return sb.toString();

    }
}
