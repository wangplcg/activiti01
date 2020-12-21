package cn.wp.geek;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * 流程实例启动
 */
public class ActivitiStartInstanceWithUel {

    /**
     * 影响表
     * act_hi_identitylink 参与者
     * act_hi_actinst  已完成活动信息， 包括event 等等动作
     * act_hi_procinst 流程实例
     * act_hi_taskinst 任务实例 只包括 task
     *
     * act_ru_identitylink 当前参与者
     * act_ru_execution 流程实例 执行表
     * act_ru_task 当前任务表
     */
    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        /**
         * businesskey 实现与业务系统的关联
         * act_ru_execution
         *
         * 3. 可以按照监听器方式实现绑定
         */
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("assignee1", "zhangsan");
        paramMap.put("assignee2", "lisi");
        paramMap.put("assignee3", "wangwu");

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("hoildayCandidate", "businesskey", paramMap);
        // 流程部署 ID
        System.out.println(processInstance.getDeploymentId());
        // 流程定义 ID
        System.out.println(processInstance.getProcessDefinitionId());
        // 实例ID
        System.out.println(processInstance.getId());
        // 活动ID
        System.out.println(processInstance.getActivityId());
    }
}
