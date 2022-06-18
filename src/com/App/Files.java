package com.App;

import java.io.*;

public class Files {
    private String fileName;


    public Files(String fileName){
        this.fileName = fileName;
    }

    public void createFile() throws IOException {
        String name = getName();

        File file = new File(name);
        boolean isDone = file.createNewFile();
        if(isDone)
            System.out.println("Direction created!");
        else System.out.println("Direction couldn't be created!");

    }

    public void writeToFile(String enterUser) throws IOException {
        String name = getName();
        OutputStream textFile =  new FileOutputStream(name, true);
        byte[] converted = enterUser.getBytes();
        try {
            textFile.write(converted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        textFile.close();

    }

    public String getName()
    {
        return this.fileName;
    }
}
