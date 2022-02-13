package securigo.services;


import securigo.domaine.Agent;

import java.io.IOException;

public interface AgentStockageInterface {
    public Agent recupererAgent(String reference) throws IOException;
}
