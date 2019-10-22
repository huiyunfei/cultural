package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.mapper.*;
import com.yunfei.cultural.model.dto.QueryParams;
import com.yunfei.cultural.model.vo.*;
import com.yunfei.cultural.service.QueryService;
import com.yunfei.cultural.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CulturalFamousHtResult> listCulturalFamousHt(QueryParams params) {
        Map pramsMap = new HashMap<>();
        switch(params.getQueryType()){
            case 1:
                pramsMap.put("name",params.getKeyword());
                break;
            case 2:
                pramsMap.put("profession",params.getKeyword());
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
                pramsMap.put("profession",params.getKeyword());
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
                pramsMap.put("profession",params.getKeyword());
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
                pramsMap.put("resume",params.getKeyword());
                break;
            case 3:
                pramsMap.put("nature",params.getKeyword());
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
}




