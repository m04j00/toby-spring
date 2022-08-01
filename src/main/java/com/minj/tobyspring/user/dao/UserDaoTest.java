package com.minj.tobyspring.user.dao;

import com.minj.tobyspring.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 1.3.3 관계 설정 책임의 분리
        // UserDao가 사용할 ConnectionMaker 구현 클래스를 결정하고 오브젝트를 만든다.
        ConnectionMaker connectionMaker = new KConnectionMaker();

        // 사용할 ConnectionMaker type의 object 제공 -> 두 오브젝트 사이의 의존관계 설정 효과
        UserDao dao = new UserDao(connectionMaker);

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
