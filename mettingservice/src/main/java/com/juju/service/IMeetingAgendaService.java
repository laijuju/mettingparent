package com.juju.service;

import com.juju.po.MeetingNotice;

import java.util.List;

public interface IMeetingAgendaService {
    /*
    查看现在所有的会议的议程
 */
    List<MeetingNotice> findMeetingAgendaAll() throws Exception;
    /*
        通过ID查看会议的议程
     */
    MeetingNotice findMeetingAgendaById(int id) throws Exception;
    /*
        通过ID修改会议的议程
     */
    void updateMeetingAgenda(MeetingNotice meetingNotice) throws Exception;
    /*
        添加会议议程
     */
    void addMeetingAgenda(MeetingNotice meetingNotice) throws Exception;
    /*
        删除一个会议议程
     */
    void deleteMeetingAgenda(int id) throws Exception;
}
