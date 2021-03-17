package com.vilas.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vilas.beans.Emp;
import com.vilas.controller.Errorhandler;
import com.vilas.repo.EmpRepository;
import com.vilas.repo.Repo2;
import com.vilas.exceptions.EmpNotFound;



@Service
public class EmpService
{	
	@Autowired
	EmpRepository repository;
	
	
	Repo2 repo2;
	
	public static final Logger logger = LogManager.getLogger(EmpService.class);

	public EmpService()
	{

	}
	
	public EmpService(Repo2 repo2)
	{
		this.repo2 = repo2;
	}
	public EmpService(EmpRepository repository)
	{
		this.repository = repository;
	}
	
	public int getMax()
	{
		
		return 5;
	}
	
	public int getMin()
	{
		
		return repo2.getMin();
	}

	public List<Emp> getAllEmp()
	{
		return repository.findAll();
	}

	public void deleteEmp(int id)
	{
		if(id>0)
	   {int i =1/0;
		repository.deleteById(id);
	   }
	}

	public void addEmp(Emp e)
	{
		logger.error("vvv Vilas Error service exceptionhandler controller... ");
		logger.info("vvv Vilas Service Error exceptionhandler controller... ");
		repository.save(e);
	}

	public Optional<Emp> getEmp(int id)
	{
		return repository.findById(id);
	}


}
