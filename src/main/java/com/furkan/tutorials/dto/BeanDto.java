package com.furkan.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long id;
    private String beanName;
    private String beanData;

    // start of bean
    public void initialBeanMethod(){
        log.info("Bean başlamadan önce ben varım.");
        System.out.println("Bean başlamadan önce çalışan metot.");
    }

    // end of bean
    public void destroyBeanMethod(){
        log.info("Bean bittikten sonra ben varım.");
        System.err.println("Bean bittikten sonra çalışan metot.");

    }
}
