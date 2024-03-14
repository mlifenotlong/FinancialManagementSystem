package com.example.rename.tool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CreateFile {

    public static Boolean createFile(String originFolder,String dirFolder) throws IOException {
        File originFile=new File(originFolder);
        File dirFile=new File(dirFolder);
        if(!originFile.exists()){
            return false;
        }
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File[] fileList=originFile.listFiles();
        for(File f:fileList){
           String movePath =dirFile+"\\"+f.getName();
           if (f.isDirectory()){
               createFile(f.getAbsolutePath(),movePath);
           }
           else {
               FileInputStream fileInputStream= new FileInputStream(f.getAbsoluteFile());

               FileOutputStream fileOutputStream= fileOutputStream = new FileOutputStream(movePath);

               byte[] b=new byte[1024];
               int t;

                   try {
                       while ((t=fileInputStream.read(b))!=-1)
                       {
                           fileOutputStream.write(b,0,t);
                       }

                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }finally {
                       fileInputStream.close();
                       fileOutputStream.close();
                   }

               }


        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        createFile("C:\\Users\\UC505523\\Desktop\\Desktop\\ProgramFiles\\EVAAService\\p1",
                "C:\\Users\\UC505523\\Desktop\\Desktop\\ProgramFiles\\EVAAService\\p3");
    }


}
