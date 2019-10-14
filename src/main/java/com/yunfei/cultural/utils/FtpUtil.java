package com.yunfei.cultural.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huiyunfei on 2018/5/9.
 */
public class FtpUtil {

    private static Logger logger = LoggerFactory.getLogger(FtpUtil.class);
    private static FTPClient ftpClient ;

    private static String ftpIp;
    private static String ftpUser;
    private static String ftpPass;



    /**
     * 连接FTP服务器
     * @param ip
     * @param user
     * @param pwd
     * @return
     */
    private static boolean connectServer(String ip, String user,String pwd ){
        boolean isSuccess = false;

        ftpClient = new FTPClient();
        try{
            /*ftpClient.connect(ip);*/
            /*下面是panney加的*/
            ftpClient.connect(ip,21);

            isSuccess =  ftpClient.login(user,pwd);
        }catch (IOException e){
            logger.error("FTP服务器连接失败",e);
        }
        return isSuccess;
    }


    public static Map uploadFile(MultipartFile[] uploadFile, String type){

        //String basePath=Global.getConfig("ftpBathPath");//"/home/casetest/";//设置服务器中文件保存的根目录
        //String basePath="/home/casetest/";//"/home/casetest/";//设置服务器中文件保存的根目录
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String filePath = dateFormat.format(now); //根据当前时间设置文件保存的子目录

        StringBuffer sb = new StringBuffer();
        Map map = new HashMap();
        map.put("status","0");
        try {
            if(connectServer(ftpIp,ftpUser,ftpPass)){
                //切换到上传目录,basepath需已存在
                if (!ftpClient.changeWorkingDirectory(filePath)) {
                    logger.info("目录"+filePath+"不存在，准备创建");
                    //如果目录不存在创建目录
                    String[] dirs = filePath.split("/");
                    String tempPath = "";
                    for (String dir : dirs) {
                        if (null == dir || "".equals(dir)) continue;
//                        if(tempPath.endsWith("/")){
//                            tempPath +=  dir+"/";
//                        }else {
//                            tempPath += "/" + dir;
//                        }
                        tempPath = dir;
                        if (!ftpClient.changeWorkingDirectory(tempPath)) {
                            if (!ftpClient.makeDirectory(tempPath)) {
                                logger.info("目录"+tempPath+"创 建失败");
                                map.put("status","1");
                                return map;
                            } else {
                                ftpClient.changeWorkingDirectory(tempPath);
                            }
                        }
                    }
                }

                if(uploadFile != null && uploadFile.length > 0){
                    logger.info("文件上传数："+uploadFile.length);
                    for(int i=0;i<uploadFile.length;i++){
                        MultipartFile file = uploadFile[i];
                        String newFileName=filePath+"/"+saveFile(file,ftpClient,type);
                        logger.info("文件上传连接："+newFileName);
                        //String newFileName=saveFile(file,ftpClient,type);
                        if(i!=0){
                            sb.append(",");
                        }
                        sb.append(newFileName);
                    }
                }
            }else{

                logger.info("ftp连接异常！");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.info("文件上传失败："+e.getMessage());
            e.printStackTrace();
        }
        map.put("urls",sb.toString());
        return map;
    }

    private static String saveFile(MultipartFile file, FTPClient client, String type){
        boolean success = false;
        InputStream inStream = null;
        try {
            //获取上传文件扩展名
            String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            //存储文件名称
            String newFileName = type+"_"+System.currentTimeMillis() + StringUtils.getRandom(4)+ extName;

            //String fileName = new String(file.getOriginalFilename());
            inStream = file.getInputStream();
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            success = client.storeFile(newFileName, inStream);
            if (success) {
                logger.info("文件"+newFileName+"上传成功！");
                return newFileName;
            }
        }  catch (Exception e) {
        	logger.info("文件上传失败："+e.getMessage());
        }finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {

                }
            }
        }
        return null;
    }

    public static boolean downloadFile(HttpServletResponse response, String fileName, String path){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data;charset=UTF-8");
        try {
            if(connectServer(ftpIp,ftpUser,ftpPass)){
                ftpClient.changeWorkingDirectory(path);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                FTPFile[] fs = ftpClient.listFiles();
                for(FTPFile ff: fs){
                    if(ff.getName().equals(fileName)){
                        response.setHeader("Content-Disposition", "attachment;fileName="+ new String( ff.getName().getBytes("gb2312"), "ISO8859-1" ) );
                        OutputStream os = response.getOutputStream();
                        ftpClient.retrieveFile(ff.getName(), os);
                        os.flush();
                        os.close();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public void setFtpClient(FTPClient ftpClient) {
        this.ftpClient = ftpClient;
    }


    @Value("ftp.ftpIp")
    public static void setFtpIp(String ftpIp) {
        FtpUtil.ftpIp = ftpIp;
    }

    @Value("ftp.ftpUser")
    public static void setFtpUser(String ftpUser) {
        FtpUtil.ftpUser = ftpUser;
    }

    @Value("ftp.ftpPass")
    public static void setFtpPass(String ftpPass) {
        FtpUtil.ftpPass = ftpPass;
    }
}
