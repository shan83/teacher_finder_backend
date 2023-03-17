package com.shan83.classfinder.service;

import com.shan83.classfinder.model.Medium;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.repository.LocationRepository;
import com.shan83.classfinder.repository.MediumRepository;
import com.shan83.classfinder.repository.TeacherRepository;

import java.util.List;
import java.util.Objects;

public class MediumService {

    private MediumRepository mediumRepository;

    // Save operation
    public Medium saveMedium(Medium medium)
    {
        return mediumRepository.save(medium);
    }

    // Read operation
    public List<Medium> fetchMediumList()
    {
        return (List<Medium>)
                mediumRepository.findAll();
    }

    // Update operation

    public Medium
    updateTeacher(Medium medium,
                  Long mediumId)
    {
        Medium depDB
                = mediumRepository.findById(mediumId)
                .get();

        if (Objects.nonNull(medium.getName())
                && !"".equalsIgnoreCase(
                medium.getName())) {
            depDB.setName(
                    medium.getName());
        }
        return mediumRepository.save(depDB);
    }

    // Delete operation
    public void deleteMediumById(Long mediumId)
    {
        mediumRepository.deleteById(mediumId);
    }
}
