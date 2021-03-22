package com.test2.test2MyHotel.repository;

import javax.transaction.Transactional;
import com.test2.test2MyHotel.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface RegionRepository extends JpaRepository<Region, Integer>{
    
}
