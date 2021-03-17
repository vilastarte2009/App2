package com.vilas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vilas.beans.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>
{

}
