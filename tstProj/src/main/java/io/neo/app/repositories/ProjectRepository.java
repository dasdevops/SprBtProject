package io.neo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.neo.app.entities.Project;
import java.lang.Integer;
import java.util.List;
import java.lang.String;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findOne(int pId);
	
	List<Project> findByProjectId(Integer projectid);
	
	List<Project> findByTitle(String title);
	

}
