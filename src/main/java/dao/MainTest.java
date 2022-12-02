package dao;

import entity.User;
import entity.UserDao;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {


        // CREATE TEST:
//        User user1 = new User() ;
//        user1.setEmail("test.mail@mail.com");
//        user1.setUserName("userWithHashedPW");
//        user1.setPassword("thisShouldBeHashed");
//
//        UserDao userDao1 = new UserDao();
//        userDao1.create(user1);


        // READ TEST
//        UserDao userDao2 = new UserDao();
//        if (userDao2.read(6) == null){
//            System.out.println("null");
//        } else {
//            String userData = userDao2.read(6).toString();
//            System.out.println(userData);
//        }
//        System.out.println(BCrypt.checkpw("thisShouldBeHashed", userDao2.read(6).getPassword()));


        // FINDALL TEST
//        UserDao allUsers = new UserDao();
//        System.out.println(Arrays.toString(allUsers.findAll()));


        // UPDATE TEST
//        UserDao userDao3 = new UserDao();
//        User user3 = userDao3.read(3);
//        user3.setUserName("Użytkownik3");
//        user3.setEmail("użytkownik_nr_3@gmail.com");
//        user3.setPassword("baaaaardzoTrudneHasło");
//        userDao3.update(user3);
//        System.out.println(user3.getId());


        // DELETE TEST
//        UserDao userDao4 = new UserDao();
//        userDao4.delete(4);


    }


}
