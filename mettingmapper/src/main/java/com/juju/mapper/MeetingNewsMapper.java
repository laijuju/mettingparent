package com.juju.mapper;

import com.juju.po.MeetingNews;

import java.util.List;

public interface MeetingNewsMapper {
    /*
        查看所有会议新闻
     */
    List<MeetingNews> findNewsAll();

    /*
        通过ID查看会议新闻
     */
    MeetingNews findNewsById(int id);

    /*
        添加会议新闻
     */
    void addNews(MeetingNews meetingNews);

    /*
        修改新闻信息
     */
    void updateNews(MeetingNews meetingNews);

    /*
        删除会议信息
     */
    void deleteNews(int id);
}
