package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

public class ACtivitiCompleteTask {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery().processDefinitionKey("hoildayCandidate").taskAssignee("lisi").list();

        for (Task task : list) {
            taskService.complete(task.getId());
        }
    }
}
