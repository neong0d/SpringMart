package com.ecom.spring_mart.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecom.spring_mart.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserControllerV1 {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("v1/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("v1/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {

        Optional<User> user = userRepository.findById(id);
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("v1/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(newUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("v1/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
