package com.liveEasy.liveEasy.Services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveEasy.liveEasy.Dao.LoadDao;
import com.liveEasy.liveEasy.entites.Loads;

@Service
public class LELoadServiceImpl implements LELoadService {
	
	
	
	@Autowired
	private LoadDao loadDao;
	

	public LELoadServiceImpl(){
		
	} 

	@Override
	public List<Loads> getLoad() {
		return loadDao.findAll();
	}

	@Override
	public Loads getLoad(long loadId) {
		
		return loadDao.findById(loadId)
                .orElseThrow(() -> new RuntimeException("Load not found with ID: " + loadId));
		
	}

	@Override
	public Loads addLoad(Loads load) {
		
		return loadDao.save(load);
	}

	@Override
	public Loads updateLoad(Loads load) {
		loadDao.save(load);
		return load;
	}

	@Override
	public void deleteLoad(long parseLong) {
		
		Loads entity = loadDao.findById(parseLong)
                .orElseThrow(() -> new RuntimeException("Load not found with ID: " + parseLong));
		loadDao.delete(entity);
	}

	@Override
	public List<Loads> getLoadsByShipperId(long shipperId) {
	    // Perform the query to retrieve loads by shipper ID
	    List<Loads> loads = loadDao.findByShipperId(shipperId);

	    // Check if the list is null, and if so, return an empty list
	    if (loads == null) {
	        return Collections.emptyList(); // Return an empty list
	    }

	    return loads;
	}

	
}
