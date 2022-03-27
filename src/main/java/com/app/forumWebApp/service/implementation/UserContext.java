package com.app.forumWebApp.service.implementation;

import com.app.forumWebApp.entities.User;

public interface UserContext {
	
	User getCurrentUser();
	void setCurrentUser(User user);

}
