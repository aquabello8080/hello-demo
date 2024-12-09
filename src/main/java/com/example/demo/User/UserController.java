/*
 * Copyright 2023 NHN (https://nhn.com) and others.
 * © NHN Corp. All rights reserved.
 */
package com.example.demo.User;

import com.example.demo.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * <p>자세한 기능을 적어주세요
 *
 * <p><b>Example:</b> 사용법을 간단히 적어주세요</p>
 *
 * <pre class="code">
 *  Demo demo = new Demo();
 *  demo.print("Hello Nhn");
 * </pre>
 *
 * @author ys.ko
 * @see com.example.demo.DemoApplication
 * @since 1.0
 */
@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private final UserDaoService userDaoService;

//    @Autowired
//    public UserController(UserDaoService userDaoService) {
//        this.userDaoService = userDaoService;
//    }

    /**
     *
     * @return
     */
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable int userId) {
        User findUser = userDaoService.findOne(userId);
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }

        return findUser;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
