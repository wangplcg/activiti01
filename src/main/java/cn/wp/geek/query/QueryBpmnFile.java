package cn.wp.geek.query;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class QueryBpmnFile {

    public static void main(String[] args) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        InputStream in = repositoryService.getResourceAsStream("15001", "diagram/holiday.bpmn");
        try {
            String s = IOUtils.toString(in);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
