package cn.wp.geek.query;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 查询当前用户任务列表
 */
public class ActivitiTaskQuery {


    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery().processDefinitionKey("Process_0781px6").taskAssignee("zhangsan").list();

        list.forEach(task -> {
            System.out.println(task.getProcessDefinitionId());
            System.out.println(task.getProcessInstanceId());
            System.out.println(task.getAssignee());
            System.out.println(task.getId());
        });
    }
}
