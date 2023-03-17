package com.shan83.classfinder.controller;

import com.shan83.classfinder.model.Location;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.service.LocationService;
import com.shan83.classfinder.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class LocationController {

    private LocationService locationService;

    // Save operation
    @PostMapping("/locations")
    public Location saveDepartment(
            @RequestBody Location location)
    {
        return locationService.saveLocation(location);
    }

    // Read operation
    @GetMapping("/locations")
    public List<String> fetchTeacherList()
    {
        return locationService.fetchLocationList();
    }


    // Update operation
    @PutMapping("/locations/{id}")
    public Location
    updateLocation(@RequestBody Location location,
                     @PathVariable("id") Long locationId)
    {
        return locationService.updateLocation(
                location, locationId);
    }

    // Delete operation
    @DeleteMapping("/locations/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long locationId)
    {
        locationService.deleteLocationById(
                locationId);
        return "Deleted Successfully";
    }
}
