package com.yunfei.cultural.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface FileService {



    public Boolean exportExcel(HttpServletResponse response, String fileName, Integer pageNum, Integer pageSize);

    public Boolean importExcel(MultipartFile fileName);

}
