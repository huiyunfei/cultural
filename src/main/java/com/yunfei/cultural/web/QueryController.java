package com.yunfei.cultural.web;

import com.alibaba.fastjson.JSONObject;
import com.yunfei.cultural.model.dto.QueryParams;
import com.yunfei.cultural.model.vo.*;
import com.yunfei.cultural.service.QueryService;
import com.yunfei.cultural.utils.StringUtils;
import com.yunfei.cultural.utils.exception.LogicException;
import com.yunfei.cultural.utils.result.ResultObj;
import com.yunfei.cultural.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huiyunfei on 2019/4/12.
 */
@Slf4j
@RestController
@RequestMapping("/query")
public class QueryController {


    @Autowired
    private QueryService queryService;


    /**
     * @Description:列表查询沪台名人数据
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/listCulturalFamousHt", method = RequestMethod.POST)
    public ResultObj listCulturalFamousHt(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("必填参数为空");
            }
            List<CulturalFamousHtResult> list = queryService.listCulturalFamousHt(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("listCulturalFamousHt error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listCulturalFamousHt system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:沪台名人详细
     * @Author:huiyunfei
     * @Date: 2019/10/21
     */
    @RequestMapping(value = "/detailCulturalFamousHt", method = RequestMethod.POST)
    public ResultObj detailCulturalFamousHt(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getId()==null){
                throw new LogicException("id为空");
            }
            CulturalFamousHtResult result = queryService.detailCulturalFamousHt(params.getId());
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("detailCulturalFamousHt error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailCulturalFamousHt system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:列表查询台湾文化人士
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/listCulturalPeopleTw", method = RequestMethod.POST)
    public ResultObj listCulturalPeopleTw(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("必填参数为空");
            }
            List<CulturalPeopleTwResult> list = queryService.listCulturalPeopleTw(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("listCulturalPeopleTw error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listCulturalPeopleTw system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:台湾文化人士详细
     * @Author:huiyunfei
     * @Date: 2019/10/21
     */
    @RequestMapping(value = "/detailCulturalPeopleTw", method = RequestMethod.POST)
    public ResultObj detailCulturalPeopleTw(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getId()==null){
                throw new LogicException("id为空");
            }
            CulturalPeopleTwResult result = queryService.detailCulturalPeopleTw(params.getId());
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("detailCulturalPeopleTw error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailCulturalPeopleTw system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:列表查询上海文化专家
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/listCulturalSpecialistSh", method = RequestMethod.POST)
    public ResultObj listCulturalSpecialistSh(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("必填参数为空");
            }
            List<CulturalSpecialistShResult> list = queryService.listCulturalSpecialistSh(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("listCulturalSpecialistSh error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listCulturalSpecialistSh system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:上海文化专家详细
     * @Author:huiyunfei
     * @Date: 2019/10/21
     */
    @RequestMapping(value = "/detailCulturalSpecialistSh", method = RequestMethod.POST)
    public ResultObj detailCulturalSpecialistSh(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getId()==null){
                throw new LogicException("id为空");
            }
            CulturalSpecialistShResult result = queryService.detailCulturalSpecialistSh(params.getId());
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("detailCulturalSpecialistSh error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailCulturalSpecialistSh system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:列表查询文化项目
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/listCulturalItem", method = RequestMethod.POST)
    public ResultObj listCulturalItem(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("必填参数为空");
            }
            List<CulturalItemResult> list = queryService.listCulturalItem(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("listCulturalItem error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listCulturalItem system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:文化项目详细
     * @Author:huiyunfei
     * @Date: 2019/10/21
     */
    @RequestMapping(value = "/detailCulturalItem", method = RequestMethod.POST)
    public ResultObj detailCulturalItem(@RequestBody JSONObject params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("id为空");
            }
            CulturalItemResult result = queryService.detailCulturalItem(params.getInteger("id"));
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("detailCulturalItem error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailCulturalItem system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }
    /**
     * @Description:列表查询文化机构
     * @Author:huiyunfei
     * @Date: 2019/10/20
     */
    @RequestMapping(value = "/listCulturalOrgan", method = RequestMethod.POST)
    public ResultObj listCulturalOrgan(@RequestBody QueryParams params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getQueryType()==null || StringUtils.isBlank(params.getKeyword())){
                throw new LogicException("必填参数为空");
            }
            List<CulturalOrganResult> list = queryService.listCulturalOrgan(params);
            ResultUtil.createSuccessResult(resultObj,"",list);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("listCulturalOrgan error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("listCulturalOrgan system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }

    /**
     * @Description:文化机构详细
     * @Author:huiyunfei
     * @Date: 2019/10/21
     */
    @RequestMapping(value = "/detailCulturalOrgan", method = RequestMethod.POST)
    public ResultObj detailCulturalOrgan(@RequestBody JSONObject params){
        ResultObj resultObj = new ResultObj();
        try {
            if(params.getInteger("id")==null){
                throw new LogicException("id为空");
            }
            CulturalOrganResult result = queryService.detailCulturalOrgan(params.getInteger("id"));
            ResultUtil.createSuccessResult(resultObj,"",result);
        } catch (LogicException e) {
            e.printStackTrace();
            log.warn("detailCulturalOrgan error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            log.error("detailCulturalOrgan system error:{}",e.getMessage());
            ResultUtil.createLocgicExceptionResult(resultObj, e.getMessage());
        }
        return resultObj;
    }


}

















