package com.roger.notice.dao.impl;

import com.roger.notice.dao.NoticeDao;
import com.roger.notice.entity.Notice;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NoticeDaoImpl implements NoticeDao {

    @PersistenceContext
    private Session session;

    @PersistenceContext
    private void setSession(Session session) {
        this.session = session;
    }

    public List<Notice> selectAll(Notice notice) {
        final String sql = "FROM Notice WHERE motNo = :motNo";

        return session.createQuery(sql, Notice.class)
                .setParameter("motNo", notice.getMotNo())
                .getResultList();
    }

}
