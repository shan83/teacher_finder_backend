package com.shan83.classfinder.service;

import com.shan83.classfinder.model.Institute;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.repository.InstituteRepository;
import com.shan83.classfinder.repository.TeacherRepository;

import java.util.List;
import java.util.Objects;

public class InstituteService {

    private InstituteRepository instituteRepository;

    // Save operation
    public Institute saveInstitute(Institute institute)
    {
        return instituteRepository.save(institute);
    }

    // Read operation
    public List<Institute> fetchInstituteList()
    {
        return (List<Institute>)
                instituteRepository.findAll();
    }

    // Update operation

    public Institute
    updateTeacher(Institute institute,
                  Long instituteId)
    {
        Institute depDB
                = instituteRepository.findById(instituteId)
                .get();

        if (Objects.nonNull(institute.getName())
                && !"".equalsIgnoreCase(
                institute.getName())) {
            depDB.setName(
                    institute.getName());
        }
        return instituteRepository.save(depDB);
    }

    // Delete operation
    public void deleteInstituteById(Long instituteId)
    {
        instituteRepository.deleteById(instituteId);
    }
}
