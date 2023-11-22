package com.lazybrary.file.pojo;

import java.io.InputStream;

public class UnzippedFile {

    private final String fileName;

    private final long fileSize;

    private final InputStream inputStream;

    public UnzippedFile(final UnzippedFile.Builder builder) {
        this.fileName = builder.fileName;
        this.fileSize = builder.fileSize;
        this.inputStream = builder.inputStream;
    }

    public static UnzippedFile.Builder builder(){
        return new UnzippedFile.Builder();
    }

    public static class Builder {
        private String fileName;

        private long fileSize;

        private InputStream inputStream;

        public UnzippedFile.Builder fileName(String fileName){
            this.fileName = fileName;
            return this;
        }

        public UnzippedFile.Builder fileSize(long fileSize){
            this.fileSize = fileSize;
            return this;
        }

        public UnzippedFile.Builder inputStream(InputStream inputStream){
            this.inputStream = inputStream;
            return this;
        }

        public UnzippedFile build(){
            return new UnzippedFile(this);
        }
    }
}
