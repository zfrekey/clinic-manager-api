package com.clinicmanager.api.controllers;


import com.clinicmanager.api.dto.user.UserCreateDTO;
import com.clinicmanager.api.dto.user.UserEditDTO;
import com.clinicmanager.api.dto.user.UserResponseDTO;
import com.clinicmanager.api.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@Valid @RequestBody UserCreateDTO data){
        return userService.create(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PatchMapping("/{id}")
    public UserResponseDTO edit(@PathVariable Long id, @RequestBody UserEditDTO User){
        return userService.edit(id, User);
    }

    @GetMapping()
    public List<UserResponseDTO> listAll(){
        return userService.listAll();
    }
}
