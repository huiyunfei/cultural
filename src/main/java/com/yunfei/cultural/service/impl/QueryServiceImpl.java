package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.mapper.*;
import com.yunfei.cultural.model.dto.QueryParams;
import com.yunfei.cultural.model.vo.*;
import com.yunfei.cultural.service.QueryService;
import com.yunfei.cultural.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private TCulturalFamousHtMapper culturalFamousHtMapper;
    @Autowired
    private TCulturalPeopleTwMapper culturalPeopleTwMapper;
    @Autowired
    private TCulturalSpecialistShMapper culturalSpecialistShMapper;
    @Autowired
    private TCulturalItemMapper culturalItemMapper;
    @Autowired
    private TCulturalOrganMapper culturalOrganMapper;
    @Autowired
    private TProfessionMapper professionMapper;
    @Autowired
    private QueryMapper queryMapper;

    @Override
    public List<CulturalFamousHtResult> listCulturalFamousHt(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("areaName",params.getKeyword());
                break;
            case 3:
                pramsMap.put("sex",params.getKeyword().equals("男")?0:1);
                break;
            case 4:
                pramsMap.put("age",params.getKeyword());
                break;
            case 5:
                pramsMap.put("profession",params.getKeyword());
                break;
            case 6:
                pramsMap.put("representativeWorks",params.getKeyword());
                break;
            case 7:
                pramsMap.put("resume",params.getKeyword());
                break;
            case 8:
                pramsMap.put("lifetime",params.getKeyword());
                break;
            case 9:
                pramsMap.put("job",params.getKeyword());
                break;
            default:
                pramsMap.put("name",params.getKeyword());
                break;
        }
        List<CulturalFamousHtResult> culturalFamousHts = culturalFamousHtMapper.selectByParams(pramsMap);
        if(culturalFamousHts!=null && culturalFamousHts.size()>0){
            culturalFamousHts.forEach(t->{
                t.setSex(DictUtils.getDictLabel(t.getSex(), "sex", null));
            });
        }
        return culturalFamousHts;
    }

    @Override
    public CulturalFamousHtResult detailCulturalFamousHt(Integer id) {
        CulturalFamousHtResult result = culturalFamousHtMapper.selectById(id);
        if(result!=null){
            result.setSex(DictUtils.getDictLabel(result.getSex(), "sex", null));
            return result;
        }
        return null;
    }

    @Override
    public List<CulturalPeopleTwResult> listCulturalPeopleTw(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("areaName",params.getKeyword());
                break;
            case 3:
                pramsMap.put("sex",params.getKeyword().equals("男")?0:1);
                break;
            case 4:
                pramsMap.put("age",params.getKeyword());
                break;
            case 5:
                pramsMap.put("profession",params.getKeyword());
                break;
            case 6:
                pramsMap.put("representativeWorks",params.getKeyword());
                break;
            case 7:
                pramsMap.put("resume",params.getKeyword());
                break;
            case 8:
                pramsMap.put("lifetime",params.getKeyword());
                break;
            case 9:
                pramsMap.put("job",params.getKeyword());
                break;
            default:
                pramsMap.put("name",params.getKeyword());
                break;
        }
        List<CulturalPeopleTwResult> culturalPeopleTwResultList = culturalPeopleTwMapper.selectByParams(pramsMap);
        if(culturalPeopleTwResultList!=null && culturalPeopleTwResultList.size()>0){
            culturalPeopleTwResultList.forEach(t->{
                t.setSex(DictUtils.getDictLabel(t.getSex(), "sex", null));
            });
        }
        return culturalPeopleTwResultList;
    }

    @Override
    public CulturalPeopleTwResult detailCulturalPeopleTw(Integer id) {
        CulturalPeopleTwResult result = culturalPeopleTwMapper.selectById(id);
        if(result!=null){
            result.setSex(DictUtils.getDictLabel(result.getSex(), "sex", null));
            return result;
        }
        return null;
    }

    @Override
    public List<CulturalSpecialistShResult> listCulturalSpecialistSh(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("areaName",params.getKeyword());
                break;
            case 3:
                pramsMap.put("sex",params.getKeyword().equals("男")?0:1);
                break;
            case 4:
                pramsMap.put("age",params.getKeyword());
                break;
            case 5:
                pramsMap.put("profession",params.getKeyword());
                break;
            case 6:
                pramsMap.put("representativeWorks",params.getKeyword());
                break;
            case 7:
                pramsMap.put("resume",params.getKeyword());
                break;
            case 8:
                pramsMap.put("lifetime",params.getKeyword());
                break;
            case 9:
                pramsMap.put("job",params.getKeyword());
                break;
            default:
                pramsMap.put("name",params.getKeyword());
                break;
        }
        List<CulturalSpecialistShResult> culturalSpecialistShResultList = culturalSpecialistShMapper.selectByParams(pramsMap);
        if(culturalSpecialistShResultList!=null && culturalSpecialistShResultList.size()>0){
            culturalSpecialistShResultList.forEach(t->{
                t.setSex(DictUtils.getDictLabel(t.getSex(), "sex", null));
            });
        }
        return culturalSpecialistShResultList;
    }

    @Override
    public CulturalSpecialistShResult detailCulturalSpecialistSh(Integer id) {
        CulturalSpecialistShResult result = culturalSpecialistShMapper.selectById(id);
        if(result!=null){
            result.setSex(DictUtils.getDictLabel(result.getSex(), "sex", null));
            return result;
        }
        return null;
    }

    @Override
    public List<CulturalItemResult> listCulturalItem(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("organizer",params.getKeyword());
                break;
            case 3:
                pramsMap.put("time",params.getKeyword());
                break;
            case 4:
                pramsMap.put("areaName",params.getKeyword());
                break;
            case 5:
                pramsMap.put("resume",params.getKeyword());
                break;
            default:
                pramsMap.put("name",params.getKeyword());
                break;
        }
        List<CulturalItemResult> list=culturalItemMapper.selectByParams(pramsMap);
        return list;
    }

    @Override
    public CulturalItemResult detailCulturalItem(Integer id) {
        CulturalItemResult result = culturalItemMapper.selectById(id);
        return result;
    }

    @Override
    public List<CulturalOrganResult> listCulturalOrgan(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("nature",params.getKeyword());
                break;
            case 3:
                pramsMap.put("setUpTime",params.getKeyword());
                break;
            case 4:
                pramsMap.put("incumbent",params.getKeyword());
                break;
            case 5:
                pramsMap.put("possessBy",params.getKeyword());
                break;
            case 6:
                pramsMap.put("resume",params.getKeyword());
                break;
            default:
                pramsMap.put("name",params.getKeyword());
                break;
        }
        List<CulturalOrganResult> list=culturalOrganMapper.selectByParams(pramsMap);
        return list;
    }

    @Override
    public CulturalOrganResult detailCulturalOrgan(Integer id) {
        CulturalOrganResult result = culturalOrganMapper.selectById(id);
        return result;
    }

    @Override
    public DataCountResult dataCount() {
        List<DataCountResult.Cell> professMap=professionMapper.countGroupByCode();
        List<DataCountResult.Cell> organMap=culturalOrganMapper.countGroupByNature();

        Integer htNum=this.culturalFamousHtMapper.countAll();
        Integer twNum=this.culturalPeopleTwMapper.countAll();
        Integer shNum=this.culturalSpecialistShMapper.countAll();
        Integer organNum=this.culturalOrganMapper.countAll();
        Integer itemNum=this.culturalItemMapper.countAll();
        List<DataCountResult.Cell> culturalPeopleList = new ArrayList<>();
        culturalPeopleList.add(DataCountResult.Cell.builder().label("沪台文化名人").num(htNum).build());
        culturalPeopleList.add(DataCountResult.Cell.builder().label("台湾文化人士").num(twNum).build());
        culturalPeopleList.add(DataCountResult.Cell.builder().label("上海文化专家").num(shNum).build());
        culturalPeopleList.add(DataCountResult.Cell.builder().label("文化机构").num(organNum).build());
        culturalPeopleList.add(DataCountResult.Cell.builder().label("文化项目").num(itemNum).build());

        List<DataCountResult.CellNew> culturaNewList = new ArrayList<>();
        DataCountResult.CellNew ht = DataCountResult.CellNew.builder().label("沪台文化名人").build();
        DataCountResult.CellNew tw = DataCountResult.CellNew.builder().label("台湾文化人士").build();
        DataCountResult.CellNew sh = DataCountResult.CellNew.builder().label("上海文化专家").build();
        DataCountResult.CellNew organ = DataCountResult.CellNew.builder().label("文化机构").build();
        DataCountResult.CellNew item = DataCountResult.CellNew.builder().label("文化项目").build();
        List<DataCountResult.Cell> todayList = this.queryMapper.countToday();
        List<DataCountResult.Cell> weekList = this.queryMapper.countWeek();
        List<DataCountResult.Cell> monthList = this.queryMapper.countMonth();
        if(todayList.size()>0){
            todayList.forEach(t->{
                switch (t.getLabel()){
                    case "ht":
                        ht.setNumDay(t.getNum());
                        break;
                    case "tw":
                        tw.setNumDay(t.getNum());
                        break;
                    case "sh":
                        sh.setNumDay(t.getNum());
                        break;
                    case "organ":
                        organ.setNumDay(t.getNum());
                        break;
                    case "item":
                        item.setNumDay(t.getNum());
                        break;
                    default:
                        break;
                }
            });
        }
        if(weekList.size()>0){
            weekList.forEach(t->{
                switch (t.getLabel()){
                    case "ht":
                        ht.setNumWeek(t.getNum());
                        break;
                    case "tw":
                        tw.setNumWeek(t.getNum());
                        break;
                    case "sh":
                        sh.setNumWeek(t.getNum());
                        break;
                    case "organ":
                        organ.setNumWeek(t.getNum());
                        break;
                    case "item":
                        item.setNumWeek(t.getNum());
                        break;
                    default:
                        break;
                }
            });
        }
        if(monthList.size()>0){
            monthList.forEach(t->{
                switch (t.getLabel()){
                    case "ht":
                        ht.setNumMonth(t.getNum());
                        break;
                    case "tw":
                        tw.setNumMonth(t.getNum());
                        break;
                    case "sh":
                        sh.setNumMonth(t.getNum());
                        break;
                    case "organ":
                        organ.setNumMonth(t.getNum());
                        break;
                    case "item":
                        item.setNumMonth(t.getNum());
                        break;
                    default:
                        break;
                }
            });
        }
        culturaNewList.add(ht);
        culturaNewList.add(tw);
        culturaNewList.add(sh);
        culturaNewList.add(organ);
        culturaNewList.add(item);

        DataCountResult build = DataCountResult.builder()
                .professMap(professMap)
                .organMap(organMap)
                .culturalPeopleMap(culturalPeopleList)
                .culturaNewMap(culturaNewList)
                .build();
        return build;
    }
}




