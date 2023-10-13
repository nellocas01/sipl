package com.example.dao.repositiories;

import com.example.dao.entities.StatusName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatusNameRepository extends JpaRepository<StatusName, Integer>, JpaSpecificationExecutor<StatusName> {
}
