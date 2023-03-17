package com.shan83.classfinder.service;

import com.shan83.classfinder.model.ClassType;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.repository.ClassTypeRepository;
import com.shan83.classfinder.repository.TeacherRepository;

import java.util.List;
import java.util.Objects;

public class ClassTypeService {

    private ClassTypeRepository classTypeRepository;

    // Save operation
    public ClassType saveClassType(ClassType classType)
    {
        return classTypeRepository.save(classType);
    }

    // Read operation
    public List<ClassType> fetchClassTypeList()
    {
        return (List<ClassType>)
                classTypeRepository.findAll();
    }

    // Read operation
    public List<ClassType> findAll()
    {
        return (List<ClassType>)
                classTypeRepository.findAll();
    }

    // Update operation

    public ClassType
    updateTeacher(ClassType classType,
                  Long classTypeId)
    {
        ClassType depDB
                = classTypeRepository.findById(classTypeId)
                .get();

        if (Objects.nonNull(classType.getName())
                && !"".equalsIgnoreCase(
                classType.getName())) {
            depDB.setName(
                    classType.getName());
        }
        return classTypeRepository.save(depDB);
    }

    // Delete operation
    public void deleteClassTypeById(Long classTypeId)
    {
        classTypeRepository.deleteById(classTypeId);
    }
}
