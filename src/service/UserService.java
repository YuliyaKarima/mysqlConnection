package service;

import dataAccessLevel.UserDAO;
import exception.IncorrectPasswordException;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import user.User;

/**
 * Class provides methods for user opreations such as login and signing up
 */
public class UserService {
    UserDAO userDAO;

    public UserService(UserDAO dao) {
        userDAO = dao;
    }

    /**
     * Method for processing of sign up operation
     *
     * @param userDTO user DTO object
     * @return user object
     */
    public User sighUp(UserDTO userDTO) {
        User user = userDAO.getUserByLogin(userDTO.getLogin());
        if (user != null) {
            throw new UserAlreadyExistsException();
        } else {
            userDAO.insertUser(UserTransformer.toUser(userDTO));
            user = userDAO.getUserByLogin(userDTO.getLogin());
            return user;
        }
    }

    /**
     * Method for processing of login operation
     *
     * @param login    user's login
     * @param password user's password
     * @return user object
     */
    public User login(String login, String password) {
        User user = userDAO.getUserByLogin(login);
        if (user == null) {
            throw new UserNotFoundException();
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new IncorrectPasswordException();
            }
        }
    }
}
