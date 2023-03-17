package com.shan83.classfinder.controller;

import com.shan83.classfinder.dto.AddResponse;
import com.shan83.classfinder.model.Add;
import com.shan83.classfinder.model.Subject;
import com.shan83.classfinder.service.AddService;
import com.shan83.classfinder.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AddController {
    private AddService addService;

    // Save operation
    @PostMapping("/adds")
    public Add saveAdd(
            @RequestBody Add add)
    {
        return addService.saveAdd(add);
    }

    // Read operation
    @GetMapping("/adds")
    public List<AddResponse> fetchAddList()
    {
        return addService.fetchAddList();
    }


    // Update operation
    @PutMapping("/adds/{id}")
    public Add
    updateAdd(@RequestBody Add add,
                   @PathVariable("id") Long addId)
    {
        return addService.updateAdd(
                add, addId);
    }

    // Delete operation
    @DeleteMapping("/adds/{id}")
    public String deleteAddById(@PathVariable("id")
                                       Long addId)
    {
        addService.deleteAddById(
                addId);
        return "Deleted Successfully";
    }
}
