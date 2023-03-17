package com.shan83.classfinder.service;

import com.shan83.classfinder.dto.SubjectResponse;
import com.shan83.classfinder.model.Location;
import com.shan83.classfinder.model.Subject;
import com.shan83.classfinder.repository.SubjectRepository;
import com.shan83.classfinder.util.SubjectMapper;
import com.shan83.classfinder.util.TeacherMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectService {

    private SubjectRepository subjectRepository;

    // Save operation
    public Subject saveSubject(Subject subject)
    {
        return subjectRepository.save(subject);
    }

    // Read operation
    public List<SubjectResponse> fetchSubjectList()
    {
        List<Subject> subjects = (List< Subject>)
                subjectRepository.findAll();
        return subjects.stream().map(SubjectMapper::mapSubjectsToResponse).toList();
    }

    // Update operation

    public Subject
    updateSubject(Subject subject,
                   Long subjectId)
    {
        Subject depDB
                = subjectRepository.findById(subjectId)
                .get();

        if (Objects.nonNull(subject.getName())
                && !"".equalsIgnoreCase(
                subject.getName())) {
            depDB.setName(
                    subject.getName());
        }
        return subjectRepository.save(depDB);
    }

    // Delete operation
    public void deleteSubjectById(Long subjectId)
    {
        subjectRepository.deleteById(subjectId);
    }
}
