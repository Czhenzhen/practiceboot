package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.io.IOException;

/**
 * 上传控制器
 *
 * @author changzhenzhen
 * @date 2018-10-31
 */

@Controller
public class UploadController {

    /**
     * 文件上传
     * mulpartFile用于接收上传的文件
     *
     * @param file
     * @return
     * @author changzhenzhen
     * date 2018-10-31
     **/
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) {

        try {
            //使用FileUtils.writeByteArrayToFile快速写文件到磁盘
            FileUtils.writeByteArrayToFile(new File("d:/upload/"
                    + file.getOriginalFilename()), file.getBytes());
            System.out.printf("////////////////////////");
            return "ok";
        } catch (IOException e) {
            System.out.println("??????????????????");
            e.printStackTrace();
            return "wrong";
        }

    }
}
