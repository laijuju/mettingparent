package com.juju.service;

import com.juju.po.MeetingNotice;

import java.util.List;

public interface IMeetingNoticeService {
    /*
    查看所有的会议通知
 */
    List<MeetingNotice> findAllMeetingNotice() throws  Exception;

    /*
        添加会议通知
     */
    void addMeetingNotice(MeetingNotice meetingNotice) throws  Exception;

    /*
        修改通知信息
     */

    void updateMeetingNotice(MeetingNotice meetingNotice) throws  Exception;

    /*
        通过ID删除会议通知
     */
    void deleteMeetingNoticeById(int id) throws  Exception;

    /*
        通过ID查询会议通知信息
     */
    MeetingNotice selectMeetingNoticeById(int id) throws  Exception;

    /*
        通过会议名字查询会议通知ID
     */
    int findNoticeIdByMeetingName(String meetingName) throws Exception;
}
