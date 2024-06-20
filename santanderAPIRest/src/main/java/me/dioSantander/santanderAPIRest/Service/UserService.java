package me.dioSantander.santanderAPIRest.Service;

import me.dioSantander.santanderAPIRest.Domain.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Long id);
    User create(User userToCreate);

}
