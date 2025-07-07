package com.zhu.pan.server;

import com.zhu.pan.core.constant.RPanConstants;
import com.zhu.pan.core.response.R;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SpringBootApplication(scanBasePackages = RPanConstants.BASE_COMPONENT_SCAN_PATH)
@ServletComponentScan(basePackages = RPanConstants.BASE_COMPONENT_SCAN_PATH)
@RestController()
@Api("接口测试类")
@Validated
public class RPanServerLauncher {
    public static void main(String[] args) {
        SpringApplication.run(RPanServerLauncher.class,args);
    }

    @GetMapping( "hello")
    public R<String> hello(@NotBlank(message = "参数不为空") String name) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        return R.success("Hello " + name + "你好1");
    }
}
