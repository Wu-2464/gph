package cn.bdqn.gph.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljh
 * @since 2020-03-18
 */
@Controller
//@RequestMapping("/brand")
public class BrandController {
    @RequestMapping("/a")
    public String a(Integer id){
        return "home/home3";
    }
    /*@RequestMapping("/")
    public String index(){
        return "home/test";
    }

    @RequestMapping("/sendSms")
    @ResponseBody
    public String sendSms(HttpServletRequest request, @RequestParam("number") String number) {
        System.out.println("123");
        JSONObject json = null;
        try {
            // JSONObject json = null;
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient
                    ("https://sms_developer.zhenzikj.com", "105010","ef99fd96-bd0f-410c-8ba9-2c626ea9990c");
            Map<String,String> params = new HashMap<String,String>();
            params.put("message","【工品汇】验证码为:"+verifyCode);
            params.put("number",number);
            String result = client.send(params);
            json = JSONObject.parseObject(result);
            if(json.getIntValue("code") != 0)//发送短信失败
                return "fail";
            //将验证码存到session中,同时存入创建时间
            //以json存放，这里使用的是阿里的fastjson
            HttpSession session = request.getSession();
            json = new JSONObject();
            json.put("verifyCode", verifyCode);
            json.put("createTime", System.currentTimeMillis());
            // 将认证码存入SESSION
            request.getSession().setAttribute("verifyCode", json);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONArray.toJSONString(json);
    }*/
}
