package com.liveEasy.liveEasy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liveEasy.liveEasy.Services.LELoadService;
import com.liveEasy.liveEasy.entites.Loads;
@RestController
@Validated
public class LELcontroller {
	
	@Autowired
	private LELoadService loadService;
	
	
	@GetMapping("/load")
	public ResponseEntity<?> getLoad(@RequestParam(value = "shipperId", required = false) Long shipperId) {
	    List<Loads> loads;
	    if (shipperId != null) {
	        loads = loadService.getLoadsByShipperId(shipperId);
	    } else {
	        loads = loadService.getLoad();
	    }

	    if (loads == null) {
	        return ResponseEntity.notFound().build();
	    } else if (loads.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(loads);
	    }
	}
	@GetMapping("/load/{loadId}")
    public Loads getLoad(@PathVariable  String loadId) {
        return this.loadService.getLoad(Long.parseLong(loadId));
    }

    @PostMapping("/load")
    public Loads addLoad(@RequestBody Loads load) {
    	
    	
    	return this.loadService.addLoad(load);
    	
        
    }

    @PutMapping("/load")
    public Loads updateLoad(@RequestBody Loads load) {
        return this.loadService.updateLoad(load);
    }

    @DeleteMapping("/load/{loadId}")
    public ResponseEntity<HttpStatus> deleteLoad(@PathVariable String loadId) {
    	try {
    		this.loadService.deleteLoad(Long.parseLong(loadId));
    		return new ResponseEntity<>(HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
}
