package com.example.rename.tool;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;

import static java.lang.System.out;

public class GetLog {
    public static void runit(String ServiceMessage, HttpSession session,String fileName,String ServiceName) throws IOException {

        JSONObject jsonObject1 = JSONObject.parseObject(ServiceMessage);
//       String ServiceName= (String) jsonObject1.get("downloadServer");
//        WebCrawlerDemo webCrawlerDemo = new WebCrawlerDemo();
//        String fileName=ServiceName+".txt";
//        File file=new File(fileName);
//
//        if(!file.exists()){
//            webCrawlerDemo.myPrint("http://logtool.int.refinitiv.com/"+ServiceName+"/ThomsonReuters/CIBORG/Engine/Logs/?C=M;O=D",fileName);
//        }

       String startDate= (String) jsonObject1.get("startDate");
       String endDate= (String) jsonObject1.get("endDate");
       Integer startMonth= Integer.valueOf(startDate.substring(5,7));
      Integer startDay= Integer.valueOf(startDate.substring(8,10));
      Integer endMonth= Integer.valueOf(endDate.substring(5,7));
      Integer endDay= Integer.valueOf(endDate.substring(8,10));
                   BufferedReader input=null;
        String str;
//        copyUrl("http://www.baidu.com");
        try {
             input= new BufferedReader
                    (new FileReader(fileName));

            while ((str = input.readLine()) != null) {
                out.println(str);
                String[] strags=str.split(" ");
                String urlString="http://logtool.int.refinitiv.com/"+ServiceName+"/ThomsonReuters/CIBORG/Engine/Logs/"+strags[0];
                if(!strags[0].contains("2022")){
//                    strags[1]=strags[0].substring(strags[0].indexOf("2022"),strags[0].indexOf("2022")+10);
                    continue;
                }
//                if(strags[0].contains("2022")){
//                    strags[1]=strags[0].substring(strags[0].indexOf("2022"),strags[0].indexOf("2022")+10);
//                }
//                if(!strags[1].contains("2022")){
//                    continue;
//                }
//                out.println(urlString.substring(urlString.indexOf("2022")+6,urlString.indexOf("2022")+7));
               String fmonth=    (strags[1].substring(strags[1].indexOf("2022")+5,strags[1].indexOf("2022")+7));
                if(fmonth.indexOf("0")==0){
                    fmonth=fmonth.substring(1,2);
                }
                Integer month=Integer.parseInt(fmonth);
                String day=    strags[1].substring(strags[1].indexOf("2022")+8,strags[1].indexOf("2022")+10);
                if(day.indexOf("0")==0){
                    day=day.substring(1,2);
                }
                Integer tday=Integer.parseInt(day);
//                month==6&&tday>=13||month==7)

                if(startMonth!=endMonth&&month==startMonth&&tday>=startDay||startMonth==endMonth&&month==startMonth&&tday>=startDay&&tday<=endDay||month>startMonth&&month<endMonth||month==endMonth&&tday<=endDay){
                    if(strags[0].endsWith(".log")||strags[0].endsWith(".log.1")){
                        session.setAttribute("month",month);
                        session.setAttribute(
                                "day",tday
                        );
                        copyUrl(urlString,strags[1]);
//                        copyUrlByChannel(urlString,strags[1]);
                    }

                }


            }
            out.println(str);
        } catch (IOException e) {

        }finally {
            input.close();
        }


    }
    public static void copyUrl(String urlString,String time) throws IOException {
        URL url=new URL(urlString);
        String inString;
        String dir="C:\\Users\\UC505523\\Desktop\\logtest";
        if(urlString.contains("UK")){
            dir=dir+"\\UKLog";
        }
//        if(urlString.contains("UK1P-DDNMCIB02A")){
//            dir=dir +"\\UK1P-DDNMCIB02A";
//        }
//        if(urlString.contains("UK1P-DDNMCIB02B")){
//            dir=dir +"\\UK1P-DDNMCIB02B";
//        }
//        if(urlString.contains("UK1P-DDNMCIB03A")){
//            dir=dir+"\\UK1P-DDNMCIB03A";
//        }
//        if(urlString.contains("UK1P-DDNMCIB03B")){
//            dir=dir+"\\UK1P-DDNMCIB03B";
//        }
//        if(urlString.contains("UK2P-DDNMCIB02A")){
//            dir=dir +"\\UK2P-DDNMCIB02A";
//        }
//        if(urlString.contains("UK2P-DDNMCIB02B")){
//            dir=dir +"\\UK2P-DDNMCIB02B";
//        }
//        if(urlString.contains("UK2P-DDNMCIB03A")){
//            dir=dir+"\\UK2P-DDNMCIB03A";
//        }
//        if(urlString.contains("UK2P-DDNMCIB03B")){
//            dir=dir+"\\UK2P-DDNMCIB03B";
//        }
        if (time.contains("2022")){
            dir=dir+ "\\"+time.substring(time.indexOf("2022"),time.indexOf("2022")+4)+time.substring(time.indexOf("2022")+5,time.indexOf("2022")+7)+time.substring(time.indexOf("2022")+8,time.indexOf("2022")+10);
        }
        out.println(dir);
        File file=new File(dir);
        out.println(file.exists());
        if(!file.exists()){
            file.mkdirs();
        }
        File outfile=new File(dir,("engine_"+urlString.substring((GetIndex.getIndexOf(urlString,"/",3)+1), GetIndex.getIndexOf(urlString,"/",4)).toLowerCase()+"_"+urlString.substring(urlString.lastIndexOf('/')+1)));
                if(!outfile.exists()){
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            PrintWriter out=new PrintWriter(new FileWriter(outfile));
            while ((inString=in.readLine())!=null){
                out.println(inString);
            }
            in.close();
            out.close();
        }




    }

    }








