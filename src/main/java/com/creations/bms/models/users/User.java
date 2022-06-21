package com.creations.bms.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

import static com.creations.bms.Preconditions.*;

@Table("users")
public class User implements Persistable<UUID> {

    @Id
    @Column("id")
    @JsonProperty("id")
    private UUID id;

    @Column("name")
    @JsonProperty("name")
    private String name;

    @Column("phone")
    @JsonProperty("phone")
    private String phone;

    @Column("email")
    @JsonProperty("email")
    private String email;

    public User() {
    }

    /**
     * @param id            the user id of the user.
     * @param name          the name of the user.
     * @param phone         the phone number of the user.
     * @param email         the email of the user.
     * @throws IllegalArgumentException in any of the following fails to be conformant:
     *                                  1. Phone number : Must be 10 characters in length and all numeric.
     *                                  2. Email : Must contain @ in the middle of the string.
     */
    public User(UUID id, String name, String phone, String email) throws IllegalArgumentException {
        validateNotNull(id);
        validateNotNull(name);
        validateNotNull(phone);
        validatePhoneNumber(phone);
        validateNotNull(email);
        validateEmail(email);
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public static User with(UserDto userDto, UUID userId) {
        return new User(userId, userDto.getName(), userDto.getPhone(), userDto.getEmail());
    }

    public static User with(UpdateUserDto userDto, User user) {
        return new User(user.getId(), userDto.getName(), userDto.getPhone(), userDto.getEmail());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
