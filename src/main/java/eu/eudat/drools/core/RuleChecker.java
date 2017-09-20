package eu.eudat.drools.core;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.json.JSONObject;


public class RuleChecker {

    public void FireRules(JSONObject sysEnv, JSONObject sysStat) {
        try {
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();


            JSONObject envTimeouts = sysEnv.optJSONObject("timeouts");
            JSONObject envLimits = sysEnv.optJSONObject("limits");


            Statistics stat = new Statistics();
            if (sysStat.has("userRunningJobs")) {
                stat.setUserRunningJobs(sysStat.getInt("userRunningJobs"));
            }
            if (sysStat.has("totalRunningJobs")) {
                stat.setTotalRunningJobs(sysStat.getInt("totalRunningJobs"));
            }
            ksession.insert(stat);



            Limits resLimits = new Limits();
            if (envLimits.has("memory")) {
                resLimits.setMemory(envLimits.getLong("memory"));
            }
            if (envLimits.has("memorySwap")) {
                resLimits.setMemorySwap(envLimits.getLong("memorySwap"));
            }
            ksession.insert(resLimits);

            Timeouts sysTimeouts = new Timeouts();
            if (envTimeouts.has("jobExecution")) {
                sysTimeouts.setJobExecution(envTimeouts.getLong("jobExecution"));
            }
            ksession.insert(sysTimeouts);

            ksession.fireAllRules();

            System.out.println("CHANGING VALUE");
            System.out.println(sysStat.getInt("userRunningJobs"));
            System.out.println(envLimits.getLong("memory"));
            System.out.println(envLimits.getLong("memorySwap"));
            System.out.println(resLimits.getMemory());
            System.out.println(sysTimeouts.getJobExecution());





        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/limits.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();

        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }


}
