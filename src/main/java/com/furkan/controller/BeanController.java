package com.furkan.controller;

import com.furkan.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Controller
public class BeanController {

    @Autowired
    BeanConfig beanConfig;

    @GetMapping("/bean/beanDto")
    @ResponseBody // Direkt ekranda göster. Html olmadan
    public String getBeanDto(){
        return beanConfig.beanDto()+"";
    }
////////////////////////////////////////////////////////////////
    @Autowired
    Logger LOG;

    /*public BeanController() {
        LOG.info("Log info çağırıldı.");
    }*/
    @PostConstruct  //
    public void init(){
        LOG.info("Log info çağırıldı.");
    }

    public static void main(String[] args) {
        BeanController controller = new BeanController();
        System.out.println(controller);
    }
}
