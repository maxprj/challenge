package com.coding.challenge.wsapi;

import com.coding.challenge.mapper.ToDoMapper;
import com.coding.challenge.wsapi.dto.ToDoCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("todo")
public class ToDoController {

    @Autowired
    private ToDoControllerService service;

    @Autowired
    private ToDoMapper mapper;

    @GetMapping
    ResponseEntity<?> getAll(@RequestParam Boolean archived) {
        return ok(service
                .getAll(archived)
                .stream()
                .map(mapper::toDTO)
                .collect(toList()));
    }

    @PostMapping
    public void create(@RequestBody ToDoCreateDTO createDTO) {
        service.create(createDTO.getDescription());
    }

    @GetMapping("/{id}/archive")
    public void archive(@PathVariable Integer id) {
        service.archive(id);
    }
}
