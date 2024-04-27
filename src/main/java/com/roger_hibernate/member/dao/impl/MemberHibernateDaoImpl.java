package com.roger_hibernate.member.dao.impl;

import com.roger_hibernate.member.dao.MemberDao_interface;
import com.roger_hibernate.member.vo.MemberVO;
import com.roger_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MemberHibernateDaoImpl implements MemberDao_interface {

    // SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
    private SessionFactory factory;

    public MemberHibernateDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    // Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
    // 以避免請求執行緒共用了同個 Session
    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public int insert(MemberVO memberVO) {
        Session session = null;
        Integer generatedKey = null;

        try {
            session = getSession(); // 獲取 Hibernate 會話

            // 開始事務
            Transaction transaction = session.beginTransaction();

            // 保存 memberVO
            generatedKey = (Integer) session.save(memberVO);

            // 提交事務
            transaction.commit();
        } catch (Exception e) {
            // 發生異常時回滾事務
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // 關閉會話
            if (session != null) {
                session.close();
            }
        }

        // 回傳生成的自增主鍵值
        return generatedKey;
    }


    @Override
    public int update(MemberVO memberVO) {
        // 開啟 Hibernate 會話
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // 開啟事務
            transaction = session.beginTransaction();

            // 執行更新操作
            session.update(memberVO);

            // 提交事務
            transaction.commit();

            // 回傳給 service，1代表修改成功
            return 1;
        } catch (Exception e) {
            // 如果發生異常，進行回滾
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

            // 回傳給 service，-1代表修改失敗
            return -1;
        } finally {
            // 關閉會話
            session.close();
        }
    }


    @Override
    public int delete(Integer memNo) {
        // 開啟 Hibernate 會話
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // 開啟事務
            transaction = session.beginTransaction();

            // 根據 memNo 獲取 MemberVO 物件
            MemberVO memberVO = session.get(MemberVO.class, memNo);

            // 檢查memberVO 是否存在
            if (memberVO != null) {
                // 刪除該物件
                session.delete(memberVO);

                // 提交事務
                transaction.commit();

                // 回傳給service，1代表刪除成功
                return 1;
            } else {
                // 如果 memberVO不存在，回滾事務
                transaction.rollback();

                // 回傳給service，-1代表刪除失敗
                return -1;
            }
        } catch (Exception e) {
            // 發生異常時，回滾事務
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

            // 回傳給service，-1代表刪除失敗
            return -1;
        } finally {
            // 關閉會話
            session.close();
        }
    }

    @Override
    public MemberVO findByPrimaryKey(Integer memNo) {
        return getSession().get(MemberVO.class, memNo);
    }

    @Override
    public MemberVO findByName(String mName) {
        return getSession().get(MemberVO.class, mName);
    }

    @Override
    public MemberVO findByAccount(String memAcc) {
        return getSession().get(MemberVO.class, memAcc);
    }

    @Override
    public List<MemberVO> getAll() {
        return getSession().createQuery("from MemberVO", MemberVO.class).list();
    }

    @Override
    public boolean isExistingMemberAccount(String memAcc) {
        // 打開一個新的 Hibernate 會話
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // 使用 HQL 查詢來查找給定的 memAcc
            String hql = "SELECT count(*) FROM MemberVO WHERE memAcc = :memAcc";
            Long count = (Long) session.createQuery(hql)
                    .setParameter("memAcc", memAcc)
                    .uniqueResult();

            // 如果 count 大於 0，則表示 memAcc 是現有的成員賬號
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();

            // 發生異常時返回false
            return false;
        } finally {
            // 關閉會話
            session.close();
        }
    }

    @Override
    public boolean isExistingMemberMobile(String memMob) {
        // 打開一個新的 Hibernate 會話
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // 使用 HQL 查詢來查找給定的 memMob
            String hql = "SELECT count(*) FROM MemberVO WHERE memMob = :memMob";
            Long count = (Long) session.createQuery(hql)
                    .setParameter("memMob", memMob)
                    .uniqueResult();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();

            // 發生異常時返回false
            return false;
        } finally {
            // 關閉會話
            session.close();
        }
    }

    @Override
    public boolean isExistingMemberMail(String memMail) {
        // 打開一個新的 Hibernate 會話
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // 使用 HQL 查詢來查找給定的 memMail
            String hql = "SELECT count(*) FROM MemberVO WHERE memMail = :memMail";
            Long count = (Long) session.createQuery(hql)
                    .setParameter("memMail", memMail)
                    .uniqueResult();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();

            // 發生異常時返回false
            return false;
        } finally {
            // 關閉會話
            session.close();
        }
    }

    @Override
    public long getTotal() {
        return getSession().createQuery("select count(*) from MemberVO", Long.class).uniqueResult();
    }


}
