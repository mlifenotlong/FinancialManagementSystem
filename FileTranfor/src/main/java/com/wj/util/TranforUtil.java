package com.wj.util;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import com.wj.filetranfor.GetFileList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TranforUtil {
    public static void fileTranfor(File originFile,File dirFile ) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(originFile);
        FileOutputStream fileOutputStream=new FileOutputStream(dirFile);
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

    public static List<String> getFileNameEndWith(List<String> fileList, String end) {
        List<String> list=new ArrayList<>();
        for(String file:fileList){
            if(file.endsWith(end)){
                File file1=new File(file);
                list.add(file1.getName());
            }

        }
        return list;
    }

    public static void getFileContentAndReplace(File file,String end,List<String> fileList) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStream=new InputStreamReader(fileInputStream);
        BufferedReader in=new BufferedReader(inputStream);
        FileWriter fileWriter=new FileWriter(file);
        BufferedWriter out=new BufferedWriter(fileWriter);
        while (in.readLine()!=null){
            if(in.readLine().endsWith(end)){
                out.append("");
            };
        }
        if(in.readLine()==null){
            for (String filename:fileList) {
                out.append(filename);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> list=new ArrayList<>();
        File file=new File("C:\\Users\\UC505523\\Desktop\\Desktop\\ProgramFiles\\EVAAService\\VAH-10\\p10\\MarketLogic\\Rules");
        list= GetFileList.getFileList(file,list);
        getFileNameEndWith(list,"vas");
        File file1=new File("C:\\Users\\UC505523\\Desktop\\Desktop\\ProgramFiles\\EVAAService\\VAH-10\\p10\\RCPF.txt");
        getFileContentAndReplace(file1,"vas",list);getFileNameEndWith(list,"vas");

    }
}
