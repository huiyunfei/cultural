package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.service.FileService;
import com.yunfei.cultural.utils.FtpUtil;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hui.yunfei@om on 2019/10/14
 */
@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("ftp.ftpServer")
    private String ftpServer;

    /**
     * @Description: 跳转文件上传页面
     * @Author: HuiYunfei
     * @Date: 2019/10/15
     */
    @RequestMapping(value = "/file")
    public String file(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("name", "yunfei");
        return "/file";
    }

    /**
     * @Description:附件上传到ftp
     * @Author:huiyunfei
     * @Date: 2018/5/15
     */
    @RequestMapping(value = "/uploadToFtp")
    @ResponseBody
    public String uploadToFtp(@RequestParam("files") MultipartFile[] files,
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


    @ResponseBody
    @RequestMapping(value = "/uploadExcel")
    public ResultObj uploadExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        ResultObj resultObj = new ResultObj();
        try {
            if(file==null || file.isEmpty()){
                throw new LogicException("excel不能为空");
            }
            fileService.uploadExcel(file);
            ResultUtil.createSuccessResult(resultObj,"导入Excel成功");
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("login error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("login system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;


    }

}
