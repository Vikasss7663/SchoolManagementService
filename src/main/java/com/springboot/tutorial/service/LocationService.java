package com.springboot.tutorial.service;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.LocationDto;
import com.springboot.tutorial.model.Location;
import com.springboot.tutorial.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;

    public List<LocationDto> getLocations() {
        List<LocationDto> locationDtos = new ArrayList<>();
        locationRepository.findAll().forEach(it -> locationDtos.add(getLocationDtoInstance(it)));
        return locationDtos;
    }

    public LocationDto getLocation(int id) {
        return getLocationDtoInstance(locationRepository.findById(id).get());
    }

    public void addLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        locationRepository.save(location);
    }

    public void updateLocation(LocationDto locationDto) {
        Location location = getLocationInstanceFromDto(locationDto);
        locationRepository.save(location);
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

    private Location getLocationInstanceFromDto(LocationDto locationDto) {
        Location location = new Location();
        location.setLocationId(locationDto.getLocationId());
        location.setBuilding(locationDto.getBuilding());
        location.setFloor(locationDto.getFloor());
        location.setRoom(locationDto.getRoom());
        return location;
    }

    private LocationDto getLocationDtoInstance(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationId(location.getLocationId());
        locationDto.setBuilding(location.getBuilding());
        locationDto.setFloor(location.getFloor());
        locationDto.setRoom(location.getRoom());
        return locationDto;
    }

}