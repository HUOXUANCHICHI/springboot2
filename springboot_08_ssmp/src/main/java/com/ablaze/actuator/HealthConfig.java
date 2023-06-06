package com.ablaze.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author: ablaze
 * @Date: 2023/06/06/17:38
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;
        if (condition) {
            builder.status(Status.UP);
            builder.withDetail("runTime", System.currentTimeMillis());
            HashMap infoMap = new HashMap();
            infoMap.put("buildTime", "2006");
            builder.withDetails(infoMap);
//            builder.up();
        } else {
            builder.status(Status.OUT_OF_SERVICE);
            builder.withDetail("上线了吗?", "你做梦");
//            builder.down();
        }

    }
}
