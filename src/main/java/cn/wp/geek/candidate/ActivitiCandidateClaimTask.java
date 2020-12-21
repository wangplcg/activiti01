package cn.wp.geek.candidate;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

public class ActivitiCandidateClaimTask {

    /**
     * 候选任务拾取
     * @param args
     */
    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("hoildayCandidate")
                .taskCandidateUser("lisi").list();

        for (Task task : list) {
            taskService.claim(task.getId(), "lisi");
            // taskService.complete(task.getId());
            // 归还任务, 归还到任务候选人中
            // taskService.setAssignee(task.getId(), null);
        }

        // 任务交接
        // 1. 保证当前用户是这个任务的负责人, 可以交接给候选人



    }
}
