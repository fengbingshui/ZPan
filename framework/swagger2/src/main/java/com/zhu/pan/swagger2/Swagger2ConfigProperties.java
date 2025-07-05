package com.zhu.pan.swagger2;

import com.zhu.pan.core.constant.RPanConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger2配置属性实体
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2ConfigProperties {

    private boolean show = true;

    private String groupName = "r-pan";

    private String basePackage = RPanConstants.BASE_COMPONENT_SCAN_PATH;

    private String title = "r-pan-server";

    private String description = "r-pan-server";

    private String termsOfServiceUrl = "http://127.0.0.1:${server.port}";

    private String contactName = "zt";

    private String contactUrl = "https://blog.zt.com";

    private String contactEmail = "zt@126.com";

    private String version = "1.0";

}
