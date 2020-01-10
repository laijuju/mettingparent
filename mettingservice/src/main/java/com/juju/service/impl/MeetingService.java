package com.juju.service.impl;

import com.juju.mapper.MeetingNoticeMapper;
import com.juju.po.MeetingNotice;
import com.juju.service.IMeetingNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeetingService implements IMeetingNoticeService {

    @Autowired
    private MeetingNoticeMapper meetingNoticeMapper;

    @Override
    public List<MeetingNotice> findAllMeetingNotice() throws  Exception {
        return meetingNoticeMapper.findAllMeetingNotice();
    }

    @Override
    public void addMeetingNotice(MeetingNotice meetingNotice) throws  Exception {
        meetingNoticeMapper.addMeetingNotice(meetingNotice);
    }

    @Override
    public void updateMeetingNotice(MeetingNotice meetingNotice) throws  Exception {
        meetingNoticeMapper.updateMeetingNotice(meetingNotice);
    }

    @Override
    public void deleteMeetingNoticeById(int id) throws  Exception {
        meetingNoticeMapper.deleteMeetingNoticeById(id);
    }

    @Override
    public MeetingNotice selectMeetingNoticeById(int id) throws  Exception{
        return meetingNoticeMapper.selectMeetingNoticeById(id);
    }
}
