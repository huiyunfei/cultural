package com.yunfei.cultural.service.impl;


import com.yunfei.cultural.service.ExcelService;
import com.yunfei.cultural.utils.excel.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {

    /**
     * 方法名：
     * 功能：导出
     */
    @Override
    public Boolean exportExcel(HttpServletResponse response, String fileName, Integer pageNum, Integer pageSize) {
        //查询数据并赋值给ExcelData
//        List<User> userList = userMapper.find();
//        List<String[]> list = new ArrayList<String[]>();
//        for (User user : userList) {
//            String[] arrs = new String[userList.size()];
//            arrs[0] = String.valueOf(user.getId());
//            arrs[1] = String.valueOf(user.getUsername());
//            arrs[2] = String.valueOf(user.getPassword());
//            arrs[3] = String.valueOf(user.getEnable());
//            list.add(arrs);
//        }
//        //表头赋值
//        String[] head = {"序列", "用户名", "密码", "状态"};
//        ExcelData data = new ExcelData();
//        data.setHead(head);
//        data.setData(list);
//        data.setFileName(fileName);
//        //实现导出
//        try {
//            ExcelUtil.exportExcel(response, data);
//            log.info("导出数据结束。。。。。。");
//            return true;
//        } catch (Exception e) {
//            log.info("导出数据失败。。。。。。");
//            return false;
//        }
        return null;
    }

    /**
     * 方法名：
     * 功能：导入
     */
    @Override
    public Boolean importExcel(String fileName) {
        log.info("导入数据开始。。。。。。");
        try {
            List<Object[]> list = ExcelUtils.importExcel(fileName);
            if(list==null || list.size()==0){
                return false;
            }
            switch(fileName){
                case "沪台文化名人.xls":
                    importFamousHt(list);
                    break;
                case "台湾文化人士.xls":
                    importPeopleTw(list);
                    break;
                case "上海文化专家.xls":
                    importSpecialistSh(list);
                    break;
                case "文化机构.xls":
                    importCulturalOrgan(list);
                    break;
                case "文化项目.xls":
                    importCulturalItem(list);
                    break;
                default:
                    break;
            }

            log.info("导入数据结束。。。。。。");
            return true;
        } catch (Exception e) {
            log.info("导入数据失败。。。。。。");
            e.printStackTrace();
        }
        return false;
    }

    private void importCulturalItem(List<Object[]> list) {
    }

    private void importCulturalOrgan(List<Object[]> list) {
    }

    private void importSpecialistSh(List<Object[]> list) {
    }

    private void importPeopleTw(List<Object[]> list) {
    }

    private void importFamousHt(List<Object[]> list) {
        for (int i = 0; i < list.size(); i++) {
//                User user = new User();
//                user.setId((Integer) list.get(i)[0]);
//                user.setUsername((String) list.get(i)[1]);
//                user.setPassword((String) list.get(i)[2]);
//                user.setEnable((Integer) list.get(i)[3]);
//                userMapper.add(user);
        }
    }

}
