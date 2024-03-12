package com.liveEasy.liveEasy.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liveEasy.liveEasy.entites.Loads;
import java.util.List;
public interface LoadDao extends JpaRepository<Loads,Long> {

	List<Loads> findByShipperId(long shipperId);
	
}
