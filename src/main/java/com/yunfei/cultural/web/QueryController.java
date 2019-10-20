package com.yunfei.cultural.web;

import com.yunfei.cultural.entity.TUser;
import com.yunfei.cultural.model.dto.CulturalFamousHtParams;
import com.yunfei.cultural.model.vo.CulturalFamousHtResult;
import com.yunfei.cultural.service.CulturalFamousHtService;
import com.yunfei.cultural.utils.StringUtils;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@RestController
@RequestMapping("/query")
public class QueryController {


    @Autowired
    private CulturalFamousHtService culturalFamousHtService;

    /**
     * @Description:查询沪台名人数据
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/queryCulturalFamousHt", method = RequestMethod.POST)
    public ResultObj queryCulturalFamousHt(@RequestBody CulturalFamousHtParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("参数有误");
            }
            List<CulturalFamousHtResult> list = culturalFamousHtService.queryCulturalFamousHt(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("queryCulturalFamousHt error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("queryCulturalFamousHt system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    @RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
    public TUser findById(@PathVariable(value="id") Integer id){
        log.info("findById in：{} ",id);
        return null;
    }
}

















