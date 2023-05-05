package data.repositories;

import shita.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shita.data.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    @BeforeEach
    public void startWith(){
         userRepository = new UserRepositoryImpl();
    }

    @Test
    public void saveOneUser_countIsOneTest(){
       assertEquals(0, userRepository.count());

       User user = new User();
       userRepository.save(user);

       assertEquals(1, userRepository.count());

    }

    @Test
    public void saveOneUser_idIsOneTest(){
        User user = new User();
        assertEquals(0, user.getId());

        User savedUser = new User();
        userRepository.save(savedUser);
        assertEquals(1, savedUser.getId());
    }

    @Test
    public void saveOneUser_FindById_ReturnUserTest(){
        User user = new User();
        assertEquals(0, user.getId());

        User savedUser = new User();
        userRepository.save(savedUser);
        User foundUser = userRepository.findById(1);
        assertEquals(1, savedUser.getId());
        assertEquals(savedUser, foundUser);
    }

    @Test
    public void saveTwoUser_SameId_CountIsOneTest(){
        User user = new User();
        user.setAddress("veeiye");
        User firstUser = userRepository.save(user);
        assertEquals(user, firstUser);

        User secondUser = new User();
        secondUser.setId(1);
        secondUser.setAddress("Lakey");
        userRepository.save(secondUser);

        User foundUser = userRepository.findById(1);

        assertEquals(foundUser,secondUser);
        assertNotEquals(foundUser, firstUser);
    }

    @Test
    public void saveOneUser_deleteOneUser_countIsZeroTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());

        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }

    @Test
    public void saveThreeUsers_deleteOne_SaveAnother_checkCount(){
        User user1 = new User();
        userRepository.save(user1);
        User user2 = new User();
        userRepository.save(user2);
        User user3 = new User();
        userRepository.save(user3);
        userRepository.delete(3);
        User user4 = new User();
        userRepository.save(user4);
        User foundUser = userRepository.findById(3);
        assertNotEquals(user3, foundUser );
        assertEquals(3, userRepository.count());
        assertEquals(4, user4.getId());

    }



}