package eu.eudat.drools.core;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.json.JSONObject;

import java.util.*;


public class RuleChecker {

    public void FireRules(JSONObject eventData) {
        Map<String, JSONObject> env = new HashMap();

        Iterator<?> keys = eventData.keys();
        while( keys.hasNext() ) {
            String key = (String)keys.next();
            if ( eventData.get(key) instanceof JSONObject ) {
                env.put(key, eventData.optJSONObject(key));
            }
        }

        try {
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            ksession.insert(eventData);
            ksession.fireAllRules();

//            System.out.println("Changed values");
//            System.out.println(eventData);

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
