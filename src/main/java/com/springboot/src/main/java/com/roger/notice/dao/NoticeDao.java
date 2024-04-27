package com.roger.notice.dao;

import com.roger.notice.entity.Notice;
import java.util.List;

public interface NoticeDao {

    /**
     * 從資料庫中選擇所有符合指定條件的 NoticeVO 實例
     *
     * @param notice 包含用於篩選紀錄條件的Notice物件，可以為null。
     * @return 一個包含符合條件的Notice實例列表。如果沒有符合條件的紀錄，則返回空列表
     */
    List<Notice> selectAll(Notice notice);
}
