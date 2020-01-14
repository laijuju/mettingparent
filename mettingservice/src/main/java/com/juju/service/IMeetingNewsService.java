package com.juju.service;

import com.juju.po.MeetingNews;

import java.util.List;

public interface IMeetingNewsService {

    /*
    查看所有会议新闻
 */
    List<MeetingNews> findNewsAll() throws Exception;

    /*
        通过ID查看会议新闻
     */
    MeetingNews findNewsById(int id) throws Exception;

    /*
        添加会议新闻
     */
    void addNews(MeetingNews meetingNews) throws Exception;

    /*
        修改新闻信息
     */
    void updateNews(MeetingNews meetingNews) throws Exception;

    /*
        删除会议信息
     */
    void deleteNews(int id) throws Exception;

}
