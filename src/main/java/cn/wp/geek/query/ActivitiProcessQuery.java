package cn.wp.geek.query;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

public class ActivitiProcessQuery {

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // Re
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 查询流程定义信息
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        List<ProcessDefinition> processDefinitions = processDefinitionQuery.processDefinitionKey("Process_0781px6")
                .orderByProcessDefinitionVersion()
                .desc()
                .list();

        // 流程定义删除
        // 涉及
        // 审批没完全结束时 删除流程定义信息会失败
        // 可以使用 repositoryService.deleteDeployment("deploymentId", ture);
        // true 表示删除没有完成的流程节点 级联删除
        // repositoryService.deleteDeployment("deploymentId");

        processDefinitions.forEach(processDefinition -> {
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getVersion());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getKey());
        });
    }
}
