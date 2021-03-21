package com.test2.test2MyHotel.repository;

import javax.transaction.Transactional;
import com.test2.test2MyHotel.model.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface JobhistoryRepository extends JpaRepository<JobHistory, Integer> {

}
