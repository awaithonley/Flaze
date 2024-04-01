package com.flaze.service;

import com.flaze.DTO.GetUserDTO;
import com.flaze.DTO.UserDTO;
import com.flaze.entity.UserEntity;
import com.flaze.exception.UserAlreadyExistException;
import com.flaze.exception.UserNotFoundException;
import com.flaze.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ArticleService articleService;

    public UserService(UserRepository userRepository, ArticleService articleService) {
        this.userRepository = userRepository;
        this.articleService = articleService;
    }

    public UserDTO registerUser(UserDTO user) throws UserAlreadyExistException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistException("Пользователь под таким username-ом уже существует");
        }

        UserEntity userEntity = userRepository.save(UserEntity.builder().
                username(user.getUsername()).
                password(user.getPassword()).
                age(user.getAge()).
                email(user.getEmail()).
                build());

        return UserDTO.builder().
                username(userEntity.getUsername()).
                age(user.getAge()).
                email(user.getEmail()).
                build();
    }

    public GetUserDTO getUser(String username) throws UserNotFoundException {
        if (!(userRepository.existsByUsername(username))) {
            throw new UserNotFoundException("Пользователь с username-ом " + username + " не найден");
        }

        Optional<UserEntity> user = userRepository.findByUsername(username);

        return GetUserDTO.builder().
                username(user.get().getUsername()).
                age(user.get().getAge()).
                email(user.get().getEmail()).
                build();
    }

    public List<GetUserDTO> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();

        List<GetUserDTO> users = new ArrayList<>();

        for (UserEntity user: userEntities) {
            users.add(GetUserDTO.builder().
                    username(user.getUsername()).
                    age(user.getAge()).
                    email(user.getEmail()).
                    articles(articleService.getAllArticles(user.getId())).
                    build());
        }

        return users;
    }

    public UserEntity updateUsername(Long id, String username) throws UserNotFoundException, UserAlreadyExistException {
        if (!(userRepository.existsById(id))) {
            throw new UserAlreadyExistException("Пользователь с id: " + id + " не существует");
        }

        if (userRepository.existsByUsername(username)) {
            throw new UserNotFoundException("Пользователь под таким username-ом уже существует");
        }

        Optional<UserEntity> user = userRepository.findById(id);

        return userRepository.save(UserEntity.builder().
                id(id).
                username(username).
                password(user.get().getPassword()).
                age(user.get().getAge()).
                email(user.get().getEmail()).
                build());
    }
}
