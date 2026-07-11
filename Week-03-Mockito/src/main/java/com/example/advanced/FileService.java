package com.example.advanced;

public class FileService {
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public String processFile() {
        String data = fileReader.read();
        fileWriter.write("Processed: " + data);
        return "Processed " + data;
    }
}
