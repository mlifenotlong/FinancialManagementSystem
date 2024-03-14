package com.example.rename.tool;

import java.io.File;
import java.util.List;

public class GetFileList {

    public static List<String> getFileList(File file, List<String> filename) {
        File[] files=file.listFiles();

        for (File f:files) {
           if(f.isDirectory()) {
               getFileList(f,filename);
           }
           else {
               filename.add(f.getName());
           }
        }
        return filename;
    }
}
