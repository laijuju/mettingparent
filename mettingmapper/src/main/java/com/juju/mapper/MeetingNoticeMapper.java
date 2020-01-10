package com.juju.mapper;

import com.juju.po.MeetingNotice;

import java.util.List;

public interface MeetingNoticeMapper {

    /*
        查看所有的会议通知
     */
    List<MeetingNotice> findAllMeetingNotice();

    /*
        添加会议通知
     */
    void addMeetingNotice(MeetingNotice meetingNotice);

    /*
        修改通知信息
     */

    void updateMeetingNotice(MeetingNotice meetingNotice);

    /*
        通过ID删除会议通知
     */
    void deleteMeetingNoticeById(int id);

    /*
        通过ID查询会议通知信息
     */
    MeetingNotice selectMeetingNoticeById(int id);
}
