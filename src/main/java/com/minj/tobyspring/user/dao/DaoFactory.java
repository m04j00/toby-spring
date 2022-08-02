package com.minj.tobyspring.user.dao;

public class DaoFactory {
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new KConnectionMaker();
        return new UserDao(connectionMaker);
    }
}
