package com.yunfei.cultural.service;

import com.yunfei.cultural.model.dto.QueryParams;
import com.yunfei.cultural.model.vo.*;

import java.util.List;

public interface QueryService {

    List<CulturalFamousHtResult> listCulturalFamousHt(QueryParams params);

    CulturalFamousHtResult detailCulturalFamousHt(Integer id);

    List<CulturalPeopleTwResult> listCulturalPeopleTw(QueryParams params);

    CulturalPeopleTwResult detailCulturalPeopleTw(Integer id);

    List<CulturalSpecialistShResult> listCulturalSpecialistSh(QueryParams params);

    CulturalSpecialistShResult detailCulturalSpecialistSh(Integer id);

    List<CulturalItemResult> listCulturalItem(QueryParams params);

    CulturalItemResult detailCulturalItem(Integer id);

    List<CulturalOrganResult> listCulturalOrgan(QueryParams params);

    CulturalOrganResult detailCulturalOrgan(Integer id);
}