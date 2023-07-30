package com.wj.filetranfor;

import com.wj.util.TranforUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReplaceFile {
    public static void compareAndReplace(File originFile,File compareFile) throws IOException {
        List<String> originFileList=new ArrayList<>();  
        GetFileList.getFileList(originFile,originFileList);
        List<String> compareFileList=new ArrayList<>();
        GetFileList.getFileList(compareFile,compareFileList);
        for (String oriFile:originFileList) {
            for (String comFile:compareFileList) {
                File file=new File(oriFile);
                File file1=new File(comFile);
                if(file.getName().equals(file1.getName())){
                    TranforUtil.fileTranfor(file1,file);
                }


            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\UC505523\\Desktop\\Desktop\\ProgramFiles\\EVAAService\\VAH-9\\p5");
        File file1=new File("C:\\Users\\UC505523\\Desktop\\code\\RulesCodeRepo\\RulesCodeRepo\\DDNMVAH09-P5");
        compareAndReplace(file,file1);
    }
}
