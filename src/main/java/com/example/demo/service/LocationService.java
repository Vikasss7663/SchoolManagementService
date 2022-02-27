package com.example.demo.service;

import com.example.demo.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.model.Location;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(int id) {
        return locationRepository.findById(id).get();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(int id, Location location) {
        locationRepository.save(location);
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

}