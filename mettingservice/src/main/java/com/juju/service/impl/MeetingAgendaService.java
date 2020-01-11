package com.juju.service.impl;

import com.juju.mapper.MeetingAgendaMapper;
import com.juju.po.MeetingNotice;
import com.juju.service.IMeetingAgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeetingAgendaService implements IMeetingAgendaService {

    @Autowired
    private MeetingAgendaMapper meetingAgendaMapper;

    @Override
    public List<MeetingNotice> findMeetingAgendaAll() throws Exception {
        return meetingAgendaMapper.findMeetingAgendaAll();
    }

    @Override
    public MeetingNotice findMeetingAgendaById(int id) throws Exception {
        return meetingAgendaMapper.findMeetingAgendaById(id);
    }

    @Override
    public void updateMeetingAgenda(MeetingNotice meetingNotice) throws Exception {
        meetingAgendaMapper.updateMeetingAgenda(meetingNotice);
    }

    @Override
    public void addMeetingAgenda(MeetingNotice meetingNotice) throws Exception {
        meetingAgendaMapper.addMeetingAgenda(meetingNotice);
    }

    @Override
    public void deleteMeetingAgenda(int id) throws Exception {
        meetingAgendaMapper.deleteMeetingAgenda(id);
    }
}
