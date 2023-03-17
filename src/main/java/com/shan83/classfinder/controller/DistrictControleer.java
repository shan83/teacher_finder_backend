package com.shan83.classfinder.controller;

import com.shan83.classfinder.model.District;
import com.shan83.classfinder.service.DistrictService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class DistrictControleer {

    private DistrictService districtService;

    // Save operation
    @PostMapping("/districts")
    public District saveDistrict(
            @RequestBody District district)
    {
        return districtService.saveDistrict(district);
    }

    // Read operation
    @GetMapping("/districts")
    public List<String> fetchDistrictList()
    {
        return districtService.fetchDistrictList();
    }

    // Read operation
    @GetMapping("/districts/{city}")
    public String fetchDistrictListByCity(@PathVariable("city") String city)
    {
        log.info("CITY : " + city);
        return districtService.searchByCitiesName_en(city);
    }


    // Update operation
    @PutMapping("/districts/{id}")
    public District
    updateDistrict(@RequestBody District district,
                   @PathVariable("id") Long districtId)
    {
        return districtService.updateDistrict(
                district, districtId);
    }

    // Delete operation
    @DeleteMapping("/districts/{id}")
    public String deleteDistrictById(@PathVariable("id")
                                       Long districtId)
    {
        districtService.deleteDistrictById(
                districtId);
        return "Deleted Successfully";
    }
}
