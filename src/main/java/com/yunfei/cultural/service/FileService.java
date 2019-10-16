package com.yunfei.cultural.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by huiyunfei on 2019/4/12.
 */
public interface FileService {


    void uploadExcel(MultipartFile file);
}
