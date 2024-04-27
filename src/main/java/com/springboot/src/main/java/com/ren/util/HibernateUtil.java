package com.ren.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    // 宣告實體變數，確保以下類別只被創建一次
    private static StandardServiceRegistry registry;
    private static final SessionFactory sessionFactory = createSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // 當呼叫此方法時會建立sessionFactory主要位於第二部分
    private static SessionFactory createSessionFactory() {
        try {
            //*** 第一部分 ***
            // 獲取註冊實例(registry)，用於建立MetadataSources物件時初始化使用
            // StandardServiceRegistry主要用於管理Hibernate的生命週期
            // 下面的Shutdown()方法時也會使用到
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            //*** 第二部分 ***
            // 在Hibernate中，sessionFactory可以透過
            // 1.Configuration類別
            // 2.Metadata類別 建立，範例為透過Metadata類別的buildSessionFactory()來建立
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void shutdown() {
        if (registry != null) {
            // 銷毀註冊
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
