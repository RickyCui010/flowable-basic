package org.flowable.flowable;

import org.flowable.engine.*;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;

public class SimpleProcess {
    public static void main(String[] args) {
        // 创建一个新的默认Flowable引擎配置。
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);

        // 构建并部署流程定义。
        ProcessEngine processEngine = cfg.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("simple-process.bpmn20.xml").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();

        // 启动流程的一个新实例。
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinition.getKey());

        // 当完成工作流程时停止引擎。
        processEngine.close();
    }
}
