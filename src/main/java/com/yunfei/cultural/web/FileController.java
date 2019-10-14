package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hui.yunfei@om on 2019/10/14
 */
@RestController
public class FileController {


    @Value("ftp.ftpServer")
    private String ftpServer;
    /**
     * @Description:附件上传到ftp
     * @Author:huiyunfei
     * @Date: 2018/5/15
     */
    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("files") MultipartFile[] files,
                         HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("fileupload system in...");
        String type = request.getParameter("type");
        System.out.println("fileupload type is..."+type);
        JSONArray array = new JSONArray();
        JSONObject jsonObject = null;
        Map map = new HashMap();
        map= FtpUtil.uploadFile(files,type);
        if(map.get("status")!=null && map.get("status").equals("0")){
            String urls = (String) map.get("urls");
            String[] url=urls.split(",");
            for(int i=0;i<url.length;i++){
                jsonObject = new JSONObject();
                jsonObject.put("name", url[i]);
                jsonObject.put("ftpServer", ftpServer);
                //array.put(jsonObject);
            }
        }
        return array.toString();
    }
}
