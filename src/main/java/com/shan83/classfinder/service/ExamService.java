package com.shan83.classfinder.service;

import com.shan83.classfinder.model.Exam;
import com.shan83.classfinder.model.Teacher;
import com.shan83.classfinder.repository.ExamRepository;
import com.shan83.classfinder.repository.TeacherRepository;

import java.util.List;
import java.util.Objects;

public class ExamService {

    private ExamRepository examRepository;

    // Save operation
    public Exam saveExam(Exam exam)
    {
        return examRepository.save(exam);
    }

    // Read operation
    public List<Exam> fetchExamList()
    {
        return (List<Exam>)
                examRepository.findAll();
    }

    // Read operation
    public List<Exam> findAll()
    {
        return (List<Exam>)
                examRepository.findAll();
    }

    // Update operation

    public Exam
    updateTeacher(Exam exam,
                  Long examId)
    {
        Exam depDB
                = examRepository.findById(examId)
                .get();

        if (Objects.nonNull(exam.getName())
                && !"".equalsIgnoreCase(
                exam.getName())) {
            depDB.setName(
                    exam.getName());
        }
        return examRepository.save(depDB);
    }

    // Delete operation
    public void deleteExamById(Long examId)
    {
        examRepository.deleteById(examId);
    }
}
