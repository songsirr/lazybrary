package com.lazybrary.file;

import com.lazybrary.file.pojo.UnzippedFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtil {

    public static List<UnzippedFile> unzipFile(Object zip) throws IOException {
        List<UnzippedFile> unzippedFiles = new ArrayList<>();
        InputStream targetStream = StreamUtil.getInputStream(zip);
        ZipInputStream zis = new ZipInputStream(targetStream);
        ZipEntry ze = zis.getNextEntry();
        while (ze != null){
            if (!ze.getName().contains("__MACOSX")) { // prevent mac os zip file
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int len = 0;
                while ((len = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                baos.flush();
                InputStream temp = new ByteArrayInputStream(baos.toByteArray());

                unzippedFiles.add(UnzippedFile.builder()
                                .fileName(ze.getName())
                                .fileSize(baos.toByteArray().length)
                                .inputStream(temp)
                        .build());

                baos.close();
            }
            zis.closeEntry();
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        return unzippedFiles;
    }
}
