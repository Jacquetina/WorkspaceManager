package com.slack.workspaceManager.model;

import java.util.Date;
import java.util.List;

public class Channel {
	
	private List<User> channelMembers;
	private String channelName;
	private Date dateCreated;
	public List<User> getChannelMembers() {
		return channelMembers;
	}
	public void setChannelMembers(List<User> channelMembers) {
		this.channelMembers = channelMembers;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
	
	

}
