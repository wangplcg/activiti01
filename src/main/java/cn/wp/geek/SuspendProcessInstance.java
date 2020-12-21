package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * 任务挂起 与激活
 */
public class SuspendProcessInstance {

    /**
     * 全部挂起  按照流程定义ID 全部挂起
     * 流程定义被挂起 不能执行流程实例   实例下所有流程实例暂停执行
     */
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().processDefinitionKey("Process_0781px6").list();

        list.forEach(instance -> {
            if (instance.isSuspended()) {
                // 暂停 激活
                // 所有的实例
                runtimeService.activateProcessInstanceById(instance.getId());
                System.out.println("流程 激活 " + instance.getId());
            } else {
                runtimeService.suspendProcessInstanceById(instance.getId());
                System.out.println("流程 挂起 " + instance.getId());
            }
        });
    }
}