package cn.bdqn.gph.controller;

import cn.bdqn.gph.service.QiniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    private QiniuService qiniuService;

    @RequestMapping("/fw")
    public String fg(){
        return "include/test";
    }

    @RequestMapping(value = "/testUpload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        if(file.isEmpty()) {
            return "error";
        }

        try {
            String fileUrl=qiniuService.saveImage(file);
            return "success, imageUrl = " + fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
