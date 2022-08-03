package com.minj.tobyspring.user.dao;

import com.minj.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        // 파라미터 `userDao`는 `ApplicationContext에 등록된 빈의 이름이다.
        // `DaoFactory`에서 `@Bean` 어노테이션을 `userDao` 이름의 메소드에 붙였는데,
        // 메소드 이름이 자동으로 빈의 이름이 된다.
        // `userDao`라는 이름의 빈을 가져온다는 것은 `DaoFactory`의 `userDao()` 메소드를 호출해서
        // 그 결과를 가져온다고 생각하면 된다.
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("m772");
        user.setName("이민지");
        user.setPassword("doremisolsolfa");
        dao.add(user);
        System.out.println(user.getId() + " 등록 성공");
        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
