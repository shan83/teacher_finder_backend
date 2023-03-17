package com.shan83.classfinder.service;

import com.shan83.classfinder.dto.AddResponse;
import com.shan83.classfinder.model.Add;
import com.shan83.classfinder.model.Subject;
import com.shan83.classfinder.repository.AddRepository;
import com.shan83.classfinder.repository.SubjectRepository;
import com.shan83.classfinder.util.AddMapper;
import com.shan83.classfinder.util.TeacherMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddService {
    private AddRepository addRepository;

    // Save operation
    public Add saveAdd(Add add)
    {
        return addRepository.save(add);
    }

    // Read operation
    public List<AddResponse> fetchAddList()
    {
        return addRepository.findAll().stream().map(AddMapper::mapAddsToResponse).toList();
    }

    // Update operation

    public Add
    updateAdd(Add add,
                  Long addId)
    {
        Add depDB
                = addRepository.findById(addId)
                .get();

        if (Objects.nonNull(add.getText())
                && !"".equalsIgnoreCase(
                add.getText())) {
            depDB.setText(
                    add.getText());
        }
        return addRepository.save(depDB);
    }

    // Delete operation
    public void deleteAddById(Long addId)
    {
        addRepository.deleteById(addId);
    }
}
