package com.creations.bms.service;

import com.creations.bms.models.users.User;
import com.creations.bms.models.users.UserDto;
import com.creations.bms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.creations.bms.Preconditions.validateNotNull;

@Service
public class UserService  {

    private final UserRepository fUserRepository;

    public UserService(UserRepository fUserRepository) {
        this.fUserRepository = fUserRepository;
    }

    public User createUser(UserDto userDto) {
        validateNotNull(userDto);
        return fUserRepository.save(User.with(userDto, UUID.randomUUID()));
    }

    public User getUser(UUID userId) {
        validateNotNull(userId);
        Optional<User> userRepositoryById = fUserRepository.findById(userId);
        return userRepositoryById.orElseThrow();
    }

    public void deleteUser(UUID userId) {
        validateNotNull(userId);
        fUserRepository.deleteById(userId);
    }

}
