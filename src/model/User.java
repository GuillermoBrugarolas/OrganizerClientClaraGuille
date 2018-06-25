package model;

import java.net.Socket;
import java.util.LinkedList;

import model.MainClient;


public class User {

	private String nickname;

	private String email;

	private String password;

	private LinkedList<Project> ownProjects;

	private LinkedList<Project> joinedProjects;
	
	public User(String nickname, String email, String password, LinkedList<Project> ownProjects, LinkedList<Project> joinedProjects){
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.ownProjects = ownProjects;
		this.joinedProjects = joinedProjects;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public LinkedList<Project> getOwnProjects() {
		return ownProjects;
	}

	public void setOwnProjects(LinkedList<Project> ownProjects) {
		this.ownProjects = ownProjects;
	}

	public LinkedList<Project> getJoinedProjects() {
		return joinedProjects;
	}

	public void setJoinedProjects(LinkedList<Project> joinedProjects) {
		this.joinedProjects = joinedProjects;
	}

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ownProjects=" + ownProjects +
                ", joinedProjects=" + joinedProjects +
                '}';
    }
}
