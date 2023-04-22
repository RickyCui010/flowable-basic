package org.flowable;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.Before;
import org.junit.Test;

public class  Test02{

    @Before
    public void testProcessEngine(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()

                .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();
        System.out.println("processEngine = " + processEngine);
    }




}