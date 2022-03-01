package com.example.demo.service;

import com.example.demo.dtos.LocationDto;
import com.example.demo.model.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocation(int id) {
        return locationRepository.findById(id).get();
    }

    public void addLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        locationRepository.save(location);
    }

    public void updateLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        location.setLocationId(locationDto.getLocationId());
        locationRepository.save(location);
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

    private Location getLocationInstanceFromDto(LocationDto locationDto) {
        Location location = new Location();
        location.setBuilding(locationDto.getBuilding());
        location.setFloor(locationDto.getFloor());
        location.setRoom(locationDto.getRoom());
        return location;
    }

}