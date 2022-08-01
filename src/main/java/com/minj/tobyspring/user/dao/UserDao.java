package com.minj.tobyspring.user.dao;

import com.minj.tobyspring.user.domain.User;

import java.sql.*;

public class UserDao {
    // 1.4.1 인터페이스 도입
    private ConnectionMaker connectionMaker; // 인터페이스를 통해 오브젝트를 접근해 구체적인 클래스 정보가 필요없다.

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setName(rs.getString("name"));
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
