package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class ActivitiTest {

    @Test
    public void testGenTable() {
        // 第二个参数可以指定 beanId
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

    @Test
    public void testGen2Table() {
        // 默认
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
    }

}
