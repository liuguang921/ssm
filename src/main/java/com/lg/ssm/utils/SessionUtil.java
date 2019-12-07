package com.lg.ssm.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-13 21:02
 */
public class SessionUtil {
    private static SqlSessionFactory sessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    static {
        // 通过getResourceAsStream方法获取项目下的指定资源
        InputStream is = SessionUtil.class.getResourceAsStream("/mybatis.cfg.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession openSession() {
        SqlSession session = threadLocal.get();
        if (null == session) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void main(String[] args) {
        SqlSession session = openSession();
        System.out.println(session.getConnection());
        session.close();
//        System.out.println(session.getConnection());
    }
}

