package com.slack.workspaceManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slack.workspaceManager.model.Workspace;
import com.slack.workspaceManager.repository.workspaceRepository;

@Service
public class workspaceService {

	@Autowired
	private workspaceRepository workspaceRepository;
	
	public boolean addWorkspace(String workspaceName) {
		Workspace workspace = new Workspace();
		workspace.setWorkspaceName(workspaceName);
		 return this.workspaceRepository.save(workspace) != null;
	}

	public boolean addChannel(String channelName) {
		// TODO Auto-generated method stub
		return false;
	}

}
