package com.slack.workspaceManager.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workspace")
public class Workspace {

		@Id
		private Integer workspaceId;
		private String workspaceName;
		private String workspaceDescription;
		private User workspaceAdmin;
		private Date createdDate;
		private List<User> workspaceMembers;
		private List<Channel> channels;
		public Integer getWorkspaceId() {
			return workspaceId;
		}
		public void setWorkspaceId(Integer workspaceId) {
			this.workspaceId = workspaceId;
		}
		public String getWorkspaceName() {
			return workspaceName;
		}
		public void setWorkspaceName(String workspaceName) {
			this.workspaceName = workspaceName;
		}
		public String getWorkspaceDescription() {
			return workspaceDescription;
		}
		public void setWorkspaceDescription(String workspaceDescription) {
			this.workspaceDescription = workspaceDescription;
		}
		public User getWorkspaceAdmin() {
			return workspaceAdmin;
		}
		public void setWorkspaceAdmin(User workspaceAdmin) {
			this.workspaceAdmin = workspaceAdmin;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public List<User> getMembers() {
			return workspaceMembers;
		}
		public void setMembers(List<User> members) {
			this.workspaceMembers = members;
		}
		public List<Channel> getChannels() {
			return channels;
		}
		public void setChannels(List<Channel> channels) {
			this.channels = channels;
		}

		
}
