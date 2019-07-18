package com.lambdaschool.ordersapp.Repos;

import com.lambdaschool.ordersapp.Models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepo extends CrudRepository<Agents, Long>
{
    Agents findByName(String AGENTNAME);
}
