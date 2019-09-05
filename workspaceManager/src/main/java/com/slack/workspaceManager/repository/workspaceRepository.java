package com.slack.workspaceManager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.slack.workspaceManager.model.Workspace;

@Repository
public interface workspaceRepository extends MongoRepository<Workspace, Integer>  {

	
}
