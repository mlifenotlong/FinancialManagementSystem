//package com.example.rename.javagit;
//
//
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.FileHandler;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//
//
//
//import org.eclipse.jgit.api.Git;
//
//
//
//import org.eclipse.jgit.transport.URIish;
//import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
//
//
//
//
//public class GitPullExam {
//
//    private static final Logger logger = Logger.getLogger(GitPullExam.class.getName());
//    private static final String LOG_DIRECTORY= "C:\\Java_Git\\CodeGitOper\\log\\";
//
//
//
//
//    public static void main(String[] args) throws IOException {
//
//
//        String localPath = "C:\\GitCopy\\DTWebsite";
//
//
//        String remoteUrl = "https://git.sami.int.thomsonreuters.com/DisplayTemplates/DTWebsite.git";
//
//
//        String username = "Kang.Chi_rft";
//
//        String password = "sEp%5r+L";
//
//
//
//
//        try {
//
//            File logFolder = new File(LOG_DIRECTORY);
//            if(!logFolder.exists()) {
//                logFolder.mkdirs();
//            }
//
//            FileHandler fileHandler = new FileHandler(LOG_DIRECTORY+"git_pull_log.txt",true);
//
//
//            SimpleFormatter simpleFormatter = new SimpleFormatter() {
//                public synchronized String format(java.util.logging.LogRecord record) {
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    String formattedDate = simpleDateFormat.format(new Date(record.getMillis()));
//                    return "["+formattedDate+"]"+record.getMessage()+"\n";
//                };
//            };
//
//            fileHandler.setFormatter(simpleFormatter);
//            logger.addHandler(fileHandler);
//
//
//            Git git = Git.open(new File(localPath));
//
//            git.remoteSetUrl()
//               .setRemoteUri(new URIish(remoteUrl))
//               .setRemoteName("origin")
//               .call();
//
//
//
//            git.pull()
//               .setRemote("origin")
//               .setRemoteBranchName("local_dev")
//               .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password))
//               .call();
//
//            logger.info("Pull successful \n");
//
//
//
//        } catch (Exception  e) {
//
//            logger.info("Failed to pull:"+e.getMessage());
//        }
//
//
//
//
//    }
//
//
//
//
//
//}