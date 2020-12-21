package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class ActivitiDeployment {

    /**
     * 流程部署 影响表数据, 流程定义删除也为下面三张表
     *   act_re_deployment   部署信息
     *   act_re_procdef      流程定义信息
     *   act_ge_bytearray    流程定义bpmn文件  资源文件
     */
    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday-candidate.bpmn")
//                可按照zip文件进行部署
//                .addZipInputStream()
                .name("请假流程-候选人")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getKey());
    }
}
