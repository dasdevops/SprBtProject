package io.neo.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.neo.app.dao.ProjectDao;
import io.neo.app.entities.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	public List<Project> getAllProjects(){
		return projectDao.getAllProjects();
	}

	@Override
	public Project getProjectById(int pId) {
		return projectDao.getProjectById(pId);
	}

	@Override
	public List<Project> findByProjectId(Integer projectid) {
		return projectDao.findByProjectId(projectid);
	}

	@Override
	public List<Project> findByTitle(String title) {
		return projectDao.findByTitle(title);
	}


}