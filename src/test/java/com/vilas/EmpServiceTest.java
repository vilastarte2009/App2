package com.vilas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import com.vilas.beans.Emp;
import com.vilas.repo.EmpRepository;
import com.vilas.repo.Repo2;
import com.vilas.service.EmpService;

import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EmpServiceTest
{
	
	
	
	
	@Test
	void testEmpListNotNull() 
	{  
		Repo2 repo2 = mock(Repo2.class);
		when(repo2.getMin()).thenReturn(1);
		
		EmpService service = new EmpService(repo2);
		assertEquals(1, service.getMin());	
		
		//assertEquals(5, service.getMax());
		
	}

}
