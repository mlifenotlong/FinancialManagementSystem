package com.wj.filetranfor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


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




}
