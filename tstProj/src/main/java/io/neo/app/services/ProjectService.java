package io.neo.app.services;

import java.util.List;

import io.neo.app.entities.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	Project getProjectById(int pId);

	public List<Project> findByProjectId(Integer projectid);
	
	public List<Project> findByTitle(String title);

}
