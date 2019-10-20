package com.yunfei.cultural.service.impl;

import com.yunfei.cultural.entity.TCulturalFamousHt;
import com.yunfei.cultural.mapper.TCulturalFamousHtMapper;
import com.yunfei.cultural.model.dto.CulturalFamousHtParams;
import com.yunfei.cultural.service.CulturalFamousHtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CulturalFamousHtServiceImpl implements CulturalFamousHtService {

    @Autowired
    private TCulturalFamousHtMapper culturalFamousHtMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return culturalFamousHtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TCulturalFamousHt record) {
        return culturalFamousHtMapper.insert(record);
    }

    @Override
    public TCulturalFamousHt selectByPrimaryKey(Integer id) {
        return culturalFamousHtMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdateBitch(List<TCulturalFamousHt> culturalFamousHtArrayList) {
        culturalFamousHtMapper.saveOrUpdateBitch(culturalFamousHtArrayList);
    }

    @Override
    public List<TCulturalFamousHt> queryCulturalFamousHt(CulturalFamousHtParams params) {
        return culturalFamousHtMapper.selectByParams(params);
    }
}