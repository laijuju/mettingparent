package com.juju.control;

import com.juju.po.MeetingNews;
import com.juju.result.MeetingNewsResult;
import com.juju.service.IMeetingNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "会议新闻功能接口测试",description = "会议新闻功能接口测试")
public class MeetingNewsController {

    Logger logger = Logger.getLogger(MeetingNewsController.class);
    @Autowired
    private IMeetingNewsService meetingNewsService;

    @ApiOperation(value = "查看所有会议新闻")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @GetMapping("findNewsAll")
    public MeetingNewsResult findNewsAll(){
        MeetingNewsResult meetingNewsResult = new MeetingNewsResult();
        meetingNewsResult.setState(0);
        try {
            List<MeetingNews> newsList = meetingNewsService.findNewsAll();
            meetingNewsResult.setState(1);
            meetingNewsResult.setMsg("查看所有会议新闻成功");
            meetingNewsResult.setMeetingNewsList(newsList);
            logger.info("查看所有会议新闻成功");
            return meetingNewsResult;
        } catch (Exception e) {
            meetingNewsResult.setMsg("查看所有会议新闻失败："+e.getMessage());
            logger.error("查看所有会议新闻失败："+e.getMessage());
            return meetingNewsResult;
        }
    }

    @ApiOperation(value = "通过ID查看会议新闻")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("findNewsById")
    public MeetingNewsResult findNewsById(@RequestBody MeetingNews meetingNews){
        MeetingNewsResult meetingNewsResult = new MeetingNewsResult();
        meetingNewsResult.setState(0);
        try {
            MeetingNews news = meetingNewsService.findNewsById(meetingNews.getId());
            meetingNewsResult.setState(1);
            meetingNewsResult.setMsg("通过ID查看会议新闻成功");
            meetingNewsResult.setMeetingNews(news);
            logger.info("通过ID查看会议新闻成功");
            return meetingNewsResult;
        } catch (Exception e) {
            meetingNewsResult.setMsg("通过ID查看会议新闻失败："+e.getMessage());
            logger.error("通过ID查看会议新闻失败："+e.getMessage());
            return meetingNewsResult;
        }
    }

    @ApiOperation(value = "添加会议新闻")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("addNews")
    public MeetingNewsResult addNews(@RequestBody MeetingNews meetingNews){
        MeetingNewsResult meetingNewsResult = new MeetingNewsResult();
        meetingNewsResult.setState(0);
        try {
            meetingNewsService.addNews(meetingNews);
            meetingNewsResult.setState(1);
            meetingNewsResult.setMsg("添加会议新闻成功");
            logger.info("添加会议新闻成功");
            return meetingNewsResult;
        } catch (Exception e) {
            meetingNewsResult.setMsg("添加会议新闻失败："+e.getMessage());
            logger.error("添加会议新闻失败："+e.getMessage());
            return meetingNewsResult;
        }
    }

    @ApiOperation(value = "修改会议新闻信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("updateNews")
    public MeetingNewsResult updateNews(@RequestBody MeetingNews meetingNews){
        MeetingNewsResult meetingNewsResult = new MeetingNewsResult();
        meetingNewsResult.setState(0);
        try {
            meetingNewsService.updateNews(meetingNews);
            meetingNewsResult.setState(1);
            meetingNewsResult.setMsg("修改会议新闻信息成功");
            logger.info("修改会议新闻信息成功");
            return meetingNewsResult;
        } catch (Exception e) {
            meetingNewsResult.setMsg("修改会议新闻信息失败："+e.getMessage());
            logger.error("修改会议新闻信息失败："+e.getMessage());
            return meetingNewsResult;
        }
    }

    @ApiOperation(value = "删除会议新闻信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("deleteNews")
    public MeetingNewsResult deleteNews(@RequestBody MeetingNews meetingNews){
        MeetingNewsResult meetingNewsResult = new MeetingNewsResult();
        meetingNewsResult.setState(0);
        try {
            meetingNewsService.deleteNews(meetingNews.getId());
            meetingNewsResult.setState(1);
            meetingNewsResult.setMsg("删除会议新闻信息成功");
            logger.info("删除会议新闻信息成功");
            return meetingNewsResult;
        } catch (Exception e) {
            logger.info("删除会议新闻信息失败："+e.getMessage());
            meetingNewsResult.setMsg("删除会议新闻信息失败："+e.getMessage());
            return meetingNewsResult;
        }
    }

}
