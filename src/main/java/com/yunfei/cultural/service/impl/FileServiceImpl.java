package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.entity.*;
import com.yunfei.cultural.mapper.*;
import com.yunfei.cultural.service.FileService;
import com.yunfei.cultural.utils.excel.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @Autowired
    private TCulturalFamousHtMapper culturalFamousHtMapper;

    @Autowired
    private TCulturalSpecialistShMapper culturalSpecialistShMapper;

    @Autowired
    private TCulturalPeopleTwMapper culturalPeopleTwMapper;

    @Autowired
    private TCulturalItemMapper culturalItemMapper;

    @Autowired
    private TCulturalOrganMapper culturalOrganMapper;

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
    public Boolean importExcel(MultipartFile file) {
        log.info("导入数据开始。。。。。。");
        try {
            List<Object[]> list = ExcelUtils.importExcel(file);
            if(list==null || list.size()==0){
                return false;
            }
            switch(file.getOriginalFilename()){
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
        List<TCulturalItem> culturalItemList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TCulturalItem culturalItem =
                    TCulturalItem.builder()
                            .id(list.get(i)[0] == null ? null : list.get(i)[0].equals("无")?null:(Integer) list.get(i)[0])
                            .name(list.get(i)[1] == null ? null :list.get(i)[1].toString())
                            .organizer(list.get(i)[2] == null ? null :  list.get(i)[2].toString())
                            .time(list.get(i)[3] == null ? null : list.get(i)[3].toString())
                            .areaCode(list.get(i)[4] == null ? null : list.get(i)[4].toString())
                            .resume(list.get(i)[5] == null ? null : list.get(i)[5].toString())
                            .picUrl(list.get(i)[6] == null ? null : list.get(i)[6].toString())
                            .build();
            culturalItemList.add(culturalItem);
            if (culturalItemList.size() == 100) {
                culturalItemMapper.saveOrUpdateBitch(culturalItemList);
                culturalItemList.clear();
            }
        }
        if(culturalItemList.size()>0){
            culturalItemMapper.saveOrUpdateBitch(culturalItemList);
        }
    }

    private void importCulturalOrgan(List<Object[]> list) {
        List<TCulturalOrgan> culturalOrganList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TCulturalOrgan culturalOrgan =
                    TCulturalOrgan.builder()
                            .id(list.get(i)[0] == null ? null : list.get(i)[0].equals("无")?null:(Integer) list.get(i)[0])
                            .name(list.get(i)[1] == null ? null :list.get(i)[1].toString())
                            .nature(list.get(i)[2] == null ? null :  list.get(i)[2].toString())
                            .setUpTime(list.get(i)[3] == null ? null : list.get(i)[3].toString())
                            .possessBy(list.get(i)[4] == null ? null : list.get(i)[4].toString())
                            .incumbent(list.get(i)[5] == null ? null : list.get(i)[5].toString())
                            .resume(list.get(i)[6] == null ? null : list.get(i)[6].toString())
                            .picUrl(list.get(i)[7] == null ? null : list.get(i)[7].toString())
                            .build();
            culturalOrganList.add(culturalOrgan);
            if (culturalOrganList.size() == 100) {
                culturalOrganMapper.saveOrUpdateBitch(culturalOrganList);
                culturalOrganList.clear();
            }
        }
        if(culturalOrganList.size()>0){
            culturalOrganMapper.saveOrUpdateBitch(culturalOrganList);
        }
    }

    private void importSpecialistSh(List<Object[]> list) {
        List<TCulturalSpecialistSh> culturalSpecialistShList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TCulturalSpecialistSh culturalSpecialistSh =
                    TCulturalSpecialistSh.builder()
                            .id(list.get(i)[0] == null ? null : list.get(i)[0].equals("无")?null:(Integer) list.get(i)[0])
                            .name(list.get(i)[1] == null ? null :list.get(i)[1].toString())
                            .areaCode(list.get(i)[2] == null ? null :  list.get(i)[2].toString())
                            .sex(list.get(i)[3] == null ? null : list.get(i)[3].equals("无")?null:(Integer) list.get(i)[3])
                            .age(list.get(i)[4] == null ? null : list.get(i)[4].equals("无")?null:(Integer) list.get(i)[4])
                            .professionCode(list.get(i)[5] == null ? null : list.get(i)[5].toString())
                            .representativeWorks(list.get(i)[6] == null ? null : list.get(i)[6].toString())
                            .resume(list.get(i)[7] == null ? null : list.get(i)[7].toString())
                            .lifetime(list.get(i)[8] == null ? null : list.get(i)[8].toString())
                            .job(list.get(i)[9] == null ? null : list.get(i)[9].toString())
                            .headUrl(list.get(i)[10] == null ? null :list.get(i)[10].toString())
                            .build();
            culturalSpecialistShList.add(culturalSpecialistSh);
            if (culturalSpecialistShList.size() == 100) {
                culturalSpecialistShMapper.saveOrUpdateBitch(culturalSpecialistShList);
                culturalSpecialistShList.clear();
            }
        }
        if(culturalSpecialistShList.size()>0){
            culturalSpecialistShMapper.saveOrUpdateBitch(culturalSpecialistShList);
        }
    }

    private void importPeopleTw(List<Object[]> list) {
        List<TCulturalPeopleTw> culturalPeopleTwList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TCulturalPeopleTw culturalPeopleTw =
                    TCulturalPeopleTw.builder()
                            .id(list.get(i)[0] == null ? null : list.get(i)[0].equals("无")?null:(Integer) list.get(i)[0])
                            .name(list.get(i)[1] == null ? null :list.get(i)[1].toString())
                            .areaCode(list.get(i)[2] == null ? null :  list.get(i)[2].toString())
                            .sex(list.get(i)[3] == null ? null : list.get(i)[3].equals("无")?null:(Integer) list.get(i)[3])
                            .age(list.get(i)[4] == null ? null : list.get(i)[4].equals("无")?null:(Integer) list.get(i)[4])
                            .professionCode(list.get(i)[5] == null ? null : list.get(i)[5].toString())
                            .representativeWorks(list.get(i)[6] == null ? null : list.get(i)[6].toString())
                            .resume(list.get(i)[7] == null ? null : list.get(i)[7].toString())
                            .lifetime(list.get(i)[8] == null ? null : list.get(i)[8].toString())
                            .job(list.get(i)[9] == null ? null : list.get(i)[9].toString())
                            .headUrl(list.get(i)[10] == null ? null :list.get(i)[10].toString())
                            .build();
            culturalPeopleTwList.add(culturalPeopleTw);
            if (culturalPeopleTwList.size() == 100) {
                culturalPeopleTwMapper.saveOrUpdateBitch(culturalPeopleTwList);
                culturalPeopleTwList.clear();
            }
        }
        if(culturalPeopleTwList.size()>0){
            culturalPeopleTwMapper.saveOrUpdateBitch(culturalPeopleTwList);
        }
    }

    private void importFamousHt(List<Object[]> list) {
        List<TCulturalFamousHt> culturalFamousHtArrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TCulturalFamousHt culturalFamousHt =
                    TCulturalFamousHt.builder()
                            .id(list.get(i)[0] == null ? null : list.get(i)[0].equals("无")?null:(Integer) list.get(i)[0])
                            .name(list.get(i)[1] == null ? null :list.get(i)[1].toString())
                            .areaCode(list.get(i)[2] == null ? null :  list.get(i)[2].toString())
                            .sex(list.get(i)[3] == null ? null : list.get(i)[3].equals("无")?null:(Integer) list.get(i)[3])
                            .age(list.get(i)[4] == null ? null : list.get(i)[4].equals("无")?null:(Integer) list.get(i)[4])
                            .professionCode(list.get(i)[5] == null ? null : list.get(i)[5].toString())
                            .representativeWorks(list.get(i)[6] == null ? null : list.get(i)[6].toString())
                            .resume(list.get(i)[7] == null ? null : list.get(i)[7].toString())
                            .lifetime(list.get(i)[8] == null ? null : list.get(i)[8].toString())
                            .job(list.get(i)[9] == null ? null : list.get(i)[9].toString())
                            .headUrl(list.get(i)[10] == null ? null :list.get(i)[10].toString())
                            .build();
            culturalFamousHtArrayList.add(culturalFamousHt);
            if (culturalFamousHtArrayList.size() == 100) {
                culturalFamousHtMapper.saveOrUpdateBitch(culturalFamousHtArrayList);
                culturalFamousHtArrayList.clear();
            }
        }
        if(culturalFamousHtArrayList.size()>0){
            culturalFamousHtMapper.saveOrUpdateBitch(culturalFamousHtArrayList);
        }
    }
}
