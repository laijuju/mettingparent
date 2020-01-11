package com.juju.mapper;

import com.juju.po.MeetingNotice;

import java.util.List;

public interface MeetingAgendaMapper {

    /*
        查看现在所有的会议的议程
     */
    List<MeetingNotice> findMeetingAgendaAll();
    /*
        通过ID查看会议的议程
     */
    MeetingNotice findMeetingAgendaById(int id);
    /*
        通过ID修改会议的议程
     */
    void updateMeetingAgenda(MeetingNotice meetingNotice);
    /*
        添加会议议程
     */
    void addMeetingAgenda(MeetingNotice meetingNotice);
    /*
        删除一个会议议程
     */
    void deleteMeetingAgenda(int id);
}
