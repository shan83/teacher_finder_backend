package com.shan83.classfinder.service;

import com.shan83.classfinder.model.Location;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.repository.LocationRepository;
import com.shan83.classfinder.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    // Save operation
    public  Location saveLocation( Location location)
    {
        return locationRepository.save(location);
    }

    // Read operation
    public List<String> fetchLocationList()
    {
        List<Location> locations = (List< Location>)
                locationRepository.findAll();
        return locations.stream()
                .map(Location::getName)
                .collect(Collectors.toList());
    }

    // Update operation

    public Location
    updateLocation(Location location,
                  Long locationId)
    {
        Location depDB
                = locationRepository.findById(locationId)
                .get();

        if (Objects.nonNull(location.getName())
                && !"".equalsIgnoreCase(
                location.getName())) {
            depDB.setName(
                    location.getName());
        }
        return locationRepository.save(depDB);
    }

    // Delete operation
    public void deleteLocationById(Long locationId)
    {
        locationRepository.deleteById(locationId);
    }
}
