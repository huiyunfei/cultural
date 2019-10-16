package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.utils.FtpUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by hui.yunfei@om on 2019/10/14
 */
@Controller
@RequestMapping("/file")
public class FileController {


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

    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(
            @RequestParam("file") MultipartFile file,HttpServletRequest req){
        try {
            String fileName = System.currentTimeMillis()+file.getOriginalFilename();
            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            System.out.println("path:"+destFile);
            System.out.println("fileName:"+fileName);
            file.transferTo(destFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }
        return "OK";
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

    /**
     * @Description: 跳转excel导入页面
     * @Author: HuiYunfei
     * @Date: 2019/10/15
     */
    @RequestMapping(value = "/excel")
    public String excel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return "/excel";
    }

    int flag=0;
    @ResponseBody
    @RequestMapping(value = "/uploadExcel")
    public String uploadExcel(@RequestParam("file") MultipartFile file,String name, HttpServletRequest request,HttpServletResponse response) {
        int count=0;
        int code=0;
        StringJoiner buffer = new StringJoiner("\n");
        JSONObject jsonObject = new JSONObject();
        try {
            if(name!=null) {
                InputStream inputStream = file.getInputStream();
                Workbook book=null;
                if(isExcel2003(name)) {
                    book=new HSSFWorkbook(inputStream);
                }
                if(isExcel2007(name)) {
                    book = new XSSFWorkbook(inputStream);
                }
                int sheetsNumber=book.getNumberOfSheets();
                Sheet sheet = book.getSheetAt(0);
                int allRowNum = sheet.getLastRowNum();
                if(allRowNum==0) {
                    flag=100;//flag是进度条的值
                    buffer.add("导入文件数据为空");
                }
                for(int i=1;i<=allRowNum;i++){
                    if(flag<100) {
                        flag=flag+(100/i);
                    }else {
                        flag=100;
                    }
                    //加载状态值，当前进度
                    //User user = new User();//我需要插入的数据类型
                    Row row = sheet.getRow(i); //获取第i行
                    /*if(row!=null) {
                        Cell cell1 = row.getCell(0); //获取第1个单元格的数据
                        Cell cell2 = row.getCell(1);
                        Cell cell3 = row.getCell(2);
                        Cell cell4 = row.getCell(3);
                        if(cell1!=null) {//姓名列验证
                            cell1.setCellType(CellType.STRING);
                            user.setName(cell1.getStringCellValue());
                        }
                        else {
                            buffer.add("第"+i+"行的第1列的数据不能为空");
                        }
                        if(cell2!=null) {//手机号码列验证
                            cell2.setCellType(CellType.STRING);
                            String verify = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
                            String moblie=cell2.getStringCellValue();
                            if(moblie.length()!=11) {
                                buffer.add("第"+i+"行的第1列的手机号码不复合要求11位");
                            }else
                            {
                                Pattern p = Pattern.compile(verify);
                                Matcher m = p.matcher(moblie);
                                boolean isMatch = m.matches();
                                if(isMatch) {
                                    User userByMoblie= userService.getUserByMobile(cell2.getStringCellValue());
                                    if(userByMoblie==null) {
                                        user.setMobile(cell2.getStringCellValue());
                                    }
                                    else {
                                        buffer.add("第"+i+"行的第1列的手机号码已存在");
                                    }

                                }
                                else {
                                    buffer.add("第"+i+"行的第1列的手机号码格式错误");
                                }
                            }

                        }
                        else {
                            buffer.add("第"+i+"行的第1列的数据不能为空");
                        }
                        if(cell3!=null) {//职位列验证
                            cell3.setCellType(CellType.STRING);
                            user.setPosition(cell3.getStringCellValue());
                        }else {
                            buffer.add("第"+i+"行的第2列的数据不能为空");
                        }
                        if(cell4!=null) {//部门列验证
                            cell4.setCellType(CellType.STRING);
                            String departmentName = cell4.getStringCellValue();
                            Department department = departmentService.getDepartmentByName(departmentName);
                            if(department!=null) {
                                user.setDepartmentCode(department.getDepartmentCode());
                            }
                            else {
                                buffer.add("第"+i+"行的第3列的数据不复合要求");
                            }

                        }else {
                            buffer.add("第"+i+"行的第3列的数据不能为空");
                        }
                        if(user.getName()!=null&&user.getMobile()!=null&&user.getPosition()!=null&&user.getDepartmentCode()!=null) {
                            count++;
                            userService.addUser(user);//保存到数据库
                        }
                    }*/
                }
                jsonObject.put("count", "共计"+allRowNum+"条数据，导入成功"+count+"条数据，导入失败"+(allRowNum-count)+"条");
                code=1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        jsonObject.put("code",code);
        jsonObject.put("message",buffer.toString());
        return jsonObject.toString();
    }

    /***
     *
     * @param 判断文件类型是不是2003版本
     * @return
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     *
     * @param 判断文件类型是不是2007版本
     * @return
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletResponse response) {
        JSONObject jsonObject=new JSONObject();
        if(flag==100) {
            jsonObject.put("code", 1);
        }
        jsonObject.put("flag", flag);
        return jsonObject.toString();
    }
}
