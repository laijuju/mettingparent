package com.juju.service.impl;

import com.juju.mapper.MeetingNewsMapper;
import com.juju.po.MeetingNews;
import com.juju.service.IMeetingNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeetingNewsService implements IMeetingNewsService {

    @Autowired
    private MeetingNewsMapper meetingNewsMapper;

    @Override
    public List<MeetingNews> findNewsAll() throws Exception {
        return meetingNewsMapper.findNewsAll();
    }

    @Override
    public MeetingNews findNewsById(int id) throws Exception {
        return meetingNewsMapper.findNewsById(id);
    }

    @Override
    public void addNews(MeetingNews meetingNews) throws Exception {
        meetingNewsMapper.addNews(meetingNews);
    }

    @Override
    public void updateNews(MeetingNews meetingNews) throws Exception {
        meetingNewsMapper.updateNews(meetingNews);
    }

    @Override
    public void deleteNews(int id) throws Exception {
        meetingNewsMapper.deleteNews(id);
    }
}
