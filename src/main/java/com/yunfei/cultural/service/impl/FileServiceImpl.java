package com.yunfei.cultural.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.rowset.internal.Row;
import com.yunfei.cultural.model.dto.LoginParams;
import com.yunfei.cultural.model.vo.LoginResult;
import com.yunfei.cultural.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.StringJoiner;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Service
public class FileServiceImpl implements FileService {



    @Override
    public void uploadExcel(MultipartFile file) throws Exception{
        int count=0;
        int code=0;
        StringJoiner buffer = new StringJoiner("\n");
        JSONObject jsonObject = new JSONObject();
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

    /***
     *
     *  判断文件类型是不是2003版本
     * @return
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     *
     * 判断文件类型是不是2007版本
     * @return
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}
