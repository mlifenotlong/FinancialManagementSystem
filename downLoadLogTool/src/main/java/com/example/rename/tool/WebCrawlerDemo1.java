package com.example.rename.tool;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerDemo1 {

    public static void main(String[] args) {
        WebCrawlerDemo1 webCrawlerDemo=new WebCrawlerDemo1();
        webCrawlerDemo.myPrint("http://logtool.int.refinitiv.com/"+"UK1P-DDNMCIB03b"+"/ThomsonReuters/CIBORG/Engine/Logs/?C=M;O=D","UK1P-DDNMCIB03b.txt");
    }

    public void myPrint(String baseUrl,String filename) {
        Map<String, Boolean> oldMap = new LinkedHashMap<String, Boolean>(); // 存储链接-是否被遍历
        // 键值对
        String oldLinkHost = "";  //host

        Pattern p = Pattern.compile("(https?://)?[^/\\s]*"); //比如：http://www.zifangsky.cn
        Matcher m = p.matcher(baseUrl);
        if (m.find()) {
            oldLinkHost = m.group();
        }

        oldMap.put(baseUrl, false);
        oldMap = crawlLinks(oldLinkHost, oldMap,filename);
        for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {
            System.out.println("链接：" + mapping.getKey());

        }

    }

    /**
     * Grab all the links that can be grabbed on a website, using a breadth-first algorithm in the idea
     * Keep making GET requests for new links that have not been traversed, until the entire set has been traversed and no new links have been found
     * indicates that no new link can be found, and the task ends
     *
     * @param oldLinkHost
     * @param oldMap  oldLinkHost domain name
     *
     * @return Returns a collection of all captured links
     * */
    private Map<String, Boolean> crawlLinks(String oldLinkHost,
                                            Map<String, Boolean> oldMap,String filename) {
        Map<String, Boolean> newMap = new LinkedHashMap<String, Boolean>();
        String oldLink = "";

        for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {
            System.out.println("link:" + mapping.getKey() + "--------check:"
                    + mapping.getValue());
            // If it hasn't been traversed
            if (!mapping.getValue()) {
                oldLink = mapping.getKey();
                // do GET request
                try {
                    URL url = new URL(oldLink);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(2000000);
                    connection.setReadTimeout(20000000);

                    if (connection.getResponseCode() == 200) {
                        InputStream inputStream = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(inputStream, "UTF-8"));
                        File file=new File(filename);
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        String line = "";
//                        Pattern pattern = Pattern
//                                .compile("<a.*?href=[\"\']?((https?://)?/?[^\"\']+)[\"\']?.*?>(.+)</a>");
                        Pattern pattern = Pattern
                                .compile("<a.*?href=[\"\']?((https?://)?/" +
                                        "?[^\"\']+)[\"\']?.*?>(.+)</a></td><td class=[\"\']indexcollastmod[\"\']>(2022-[0-9][0-9]-[0-9][0-9]).*?</td><td class=[\"\']indexcolsize[\"\']>(.+?)<");

                        Matcher matcher = null;
                        while ((line = reader.readLine()) != null) {

                            matcher = pattern.matcher(line);

                            if (matcher.find()) {

                                String newLink = matcher.group(1).trim(); // link\
                                String t2=matcher.group(3).trim();
                                String tt=matcher.group(4).trim();//time
                                String t3=matcher.group(5).trim();
                                System.out.println(tt);
//                                System.out.println(tt);
//                                System.out.println(newLink);
                                String dir="C:\\Users\\UC505523\\Desktop\\logtest";
                                dir+="\\2022 UK1 3b";
                                File file2=new File(dir);
                                if(!file2.exists()){
                                    file2.mkdirs();
                                }
                                dir=dir+"\\"+tt+".txt";

                                File file1=new File(dir);
                                if(!file1.exists()){

                                    file1.createNewFile();
                                }
                                newLink=newLink+" "+tt+"  "+t3+"\r\n";

                                OutputStream stream=null;
                                try {
                                    stream=new FileOutputStream(file1,true);
                                    byte[] bytes=newLink.getBytes();
                                    stream.write(bytes);
                                }catch (Exception e){

                                }finally {
                                    stream.close();
                                }


                            }
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                oldMap.replace(oldLink, false, true);
            }
        }
        //There's a new link. Keep going
        if (!newMap.isEmpty()) {
            oldMap.putAll(newMap);
            oldMap.putAll(crawlLinks(oldLinkHost, oldMap,filename));  //Because of the nature of Map, duplicate key-value pairs do not occur
        }
        return oldMap;
    }

}