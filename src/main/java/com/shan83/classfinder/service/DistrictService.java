package com.shan83.classfinder.service;

import com.shan83.classfinder.model.District;
import com.shan83.classfinder.model.Location;
import com.shan83.classfinder.repository.DistrictRepository;
import com.shan83.classfinder.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistrictService {

    private DistrictRepository districtRepository;

    // Save operation
    public District saveDistrict(District district)
    {
        return districtRepository.save(district);
    }

    // Read operation
    public List<String> fetchDistrictList()
    {
        List<District> districts = (List< District>)
                districtRepository.findAll();
        return districts.stream()
                .map(District::getNameEn)
                .collect(Collectors.toList());
    }

    public String searchByCitiesName_en(String city)
    {
        District district = districtRepository.searchByCitiesNameEn(city);
        return district.getNameEn();
    }

    // Update operation

    public District
    updateDistrict(District distric,
                   Long districtId)
    {
        District depDB
                = districtRepository.findById(districtId)
                .get();

        if (Objects.nonNull(distric.getNameEn())
                && !"".equalsIgnoreCase(
                distric.getNameEn())) {
            depDB.setNameEn(
                    distric.getNameEn());
        }
        return districtRepository.save(depDB);
    }

    // Delete operation
    public void deleteDistrictById(Long districtId)
    {
        districtRepository.deleteById(districtId);
    }
}
