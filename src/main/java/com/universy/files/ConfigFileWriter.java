package com.universy.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ConfigFileWriter {

    private static final String FILE_PATH_TEMPLATE = "%s/config";
    private static final String FILE_NAME = "/config.json";

    private final String content;


    public ConfigFileWriter(String content) {
        this.content = content;
    }

    public void write() throws IOException {
        String path = getDirPath();
        writeFile(path, content);
    }

    private String getDirPath() throws IOException {
        File dir = new File(createPath());

        if(!dir.exists()){
            dir.mkdirs();
        }

        File file = new File(dir.getAbsolutePath() + FILE_NAME);
        file.createNewFile();

        return file.getAbsolutePath();
    }

    private String createPath() {
        return String.format(FILE_PATH_TEMPLATE, getBaseDir());
    }

    private void writeFile(String filePath, String content) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(filePath))) {
            out.print(content);
        }
    }


    private String getBaseDir(){
        return System.getProperty("user.dir");
    }
}
