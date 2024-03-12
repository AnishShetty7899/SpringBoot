package com.liveEasy.liveEasy.Services;

import java.util.List;

import com.liveEasy.liveEasy.entites.Loads;

public interface LELoadService {
	public List<Loads> getLoad();
	
	public Loads getLoad(long loadId);
	
	public Loads addLoad(Loads load);
	public Loads updateLoad(Loads load);
	public void deleteLoad(long parseLong);
	List<Loads> getLoadsByShipperId(long shipperId);
	
}
