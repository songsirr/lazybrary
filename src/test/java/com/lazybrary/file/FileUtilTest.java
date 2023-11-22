package com.lazybrary.file;

import com.lazybrary.file.pojo.UnzippedFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void unzipFile() throws Exception {
        String path = "src/test/resources/zip/testzip.zip";
        List<UnzippedFile> files = FileUtil.unzipFile(path);
        Assertions.assertNotEquals(files.size(), 0);
    }
}