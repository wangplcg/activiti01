package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * 任务挂起 与激活
 */
public class SuspendProcessDefinition {

    /**
     * 全部挂起  按照流程定义ID 全部挂起
     * 流程定义被挂起 不能执行流程实例   实例下所有流程实例暂停执行
     */
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey("Process_0781px6").list();

        processDefinitions.forEach(processDefinition -> {
            if (processDefinition.isSuspended()) {
                // 暂停 激活
                // 所有的实例
                repositoryService.activateProcessDefinitionById(processDefinition.getId(), true, null);
                System.out.println("实例 激活 " + processDefinition.getId());
            } else {
                repositoryService.suspendProcessDefinitionById(processDefinition.getId(), true, null);
                System.out.println("实例 挂起 " + processDefinition.getId());
            }
        });
    }
}