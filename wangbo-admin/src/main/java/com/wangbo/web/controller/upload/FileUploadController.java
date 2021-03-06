package com.wangbo.web.controller.upload;

import com.wangbo.common.config.Global;
import com.wangbo.common.exception.BusinessException;
import com.wangbo.system.entity.SysOss;
import com.wangbo.system.service.ISysOssService;
import com.wangbo.web.controller.upload.cloud.CloudStorageService;
import com.wangbo.web.controller.upload.cloud.OSSFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description: 图片上传
 * @author: xingyu
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private ISysOssService sysOssService;

    /** 图片命名格式 */
    private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyyMMddHHmmss";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 上传图片文件夹 */
    private static final String UPLOAD_PATH = Global.getProfile();

    /** 上传图片URL */
    private static final String URL_PATH = Global.getVisiteUrl();

    /** 上传图片 本地 */
    @PostMapping("/upload")
    @ResponseBody
    public UploadImageResModel  uploadImg(@RequestParam("upload") MultipartFile multipartFile) {

        if (multipartFile == null || multipartFile.isEmpty()){
            return UploadImageResModel.error("isEmpty");
        }
        //生成新的文件名及存储位置
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()
                .replaceAll("-", "")
                .concat(fileName.substring(fileName.lastIndexOf(".")));

        String fullPath = UPLOAD_PATH.concat(newFileName);

        try {
            File target = new File(fullPath);
            //判断文件父目录是否存在
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
            }

            multipartFile.transferTo(target);

            String imgUrl = "http://localhost:80/profile/".concat(newFileName);
            //保存文件信息
            SysOss oss = new SysOss();
            oss.setFileUrl(imgUrl);
            oss.setFileName(fileName);
            oss.setFileHome("0");
            oss.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
            sysOssService.insertSysOss(oss);
            return UploadImageResModel.ok(1,fileName,imgUrl);
        } catch (IOException ex) {
            logger.error("上传图片异常", ex);
        }

        return UploadImageResModel.error("isEmpty");
    }

    /** cloudUpload 云存储*/
    @PostMapping("/cloudUpload")
    @ResponseBody
    public UploadImageResModel  cloudUpload(@RequestParam("upload") MultipartFile multipartFile) throws IOException{
        if (multipartFile.isEmpty()) {
            throw new BusinessException("上传文件不能为空");
        }
        //上传文件
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        CloudStorageService storage = OSSFactory.build();
        String url =storage.uploadSuffix(multipartFile.getBytes(), suffix);

        //保存文件信息
        SysOss oss = new SysOss();
        oss.setFileUrl(url);
        oss.setFileName(fileName);
        oss.setFileHome("1");
        oss.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
        sysOssService.insertSysOss(oss);

        return UploadImageResModel.ok(1,fileName,url);
    }

}
