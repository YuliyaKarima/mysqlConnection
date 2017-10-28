package service;

import service.UserDTO;
import user.User;

/**
 * Class for transforming user object to user data transfer objects (DTO)
 * and user DTO object to user object
 */
public class UserTransformer {

    /**
     * Return user object from DTO object
     *
     * @param dto user DTO object
     * @return user object
     */
    public static User toUser(UserDTO dto) {
        return dto.getUser();
    }

    /**Return user DTO object from user object
     *
     * @param user user object
     * @return user DTO object
     */
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user);
    }
}

