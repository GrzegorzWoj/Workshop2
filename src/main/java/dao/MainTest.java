package dao;

import entity.User;
import entity.UserDao;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {


        // CREATE TEST:
//        User user1 = new User() ;
//        user1.setEmail("user_2@email.com");
//        user1.setUserName("TestUser2");
//        user1.setPassword("testPassword2");
//
//        UserDao userDao1 = new UserDao();
//        userDao1.create(user1);


        // READ TEST
//        UserDao userDao2 = new UserDao();
//        if (userDao2.read(3) == null){
//            System.out.println("null");
//        } else {
//            String userData = userDao2.read(3).toString();
//            System.out.println(userData);
//        }


        // FINDALL TEST
//        UserDao allUsers = new UserDao();
//        System.out.println(Arrays.toString(allUsers.findAll()));


        // UPDATE TEST
//        UserDao userDao3 = new UserDao();
//        User user3 = userDao3.read(3);
//        user3.setUserName("Użytkownik3");
//        user3.setEmail("użytkownik_nr_3@gmail.com");
//        user3.setPassword("baaardzoTrudneHasło");
//        userDao3.update(user3);
//        System.out.println(user3.getId());


        // DELETE TEST
        UserDao userDao4 = new UserDao();
        userDao4.delete(4);







    }



}
