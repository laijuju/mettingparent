package com.juju.control;

import com.juju.po.MeetingNotice;
import com.juju.result.MeetingNoticeResult;
import com.juju.service.IMeetingNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "会议通知功能借口测试", description = "会议通知功能借口测试")
public class MeetingNoticeController {

    Logger logger = Logger.getLogger(MeetingNoticeController.class);

    @Autowired
    private IMeetingNoticeService meetingNoticeService;

    @ApiOperation(value = "查看所有会议通知")
    @GetMapping("findAllMeetingNotice")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    public MeetingNoticeResult findAllMeetingNotice() {
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            List<MeetingNotice> allMeetingNotice = meetingNoticeService.findAllMeetingNotice();
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMeetingNotices(allMeetingNotice);
            meetingNoticeResult.setMsg("查询所有会议通知成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("查询所有会议通知失败：" + e.getMessage());
            logger.error("查询所有会议通知失败：" + e.getMessage());
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "通过ID查询会议通知")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("selectMeetingNoticeById")
    public MeetingNoticeResult selectMeetingNoticeById(@RequestBody MeetingNotice meetingNotice) {
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            MeetingNotice meeting = meetingNoticeService.selectMeetingNoticeById(meetingNotice.getId());
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("通过ID查询会议通知成功");
            meetingNoticeResult.setMeetingNotice(meeting);
            logger.info("通过ID查询会议通知成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("通过ID查询会议通知失败");
            logger.error("通过ID查询会议通知成功");
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "删除会议信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("deleteMeetingNoticeById")
    public MeetingNoticeResult deleteMeetingNotice(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            meetingNoticeService.deleteMeetingNoticeById(meetingNotice.getId());
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("删除会议信息成功");
            logger.info("删除会议信息成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("删除会议信息失败："+e.getMessage());
            logger.error("删除会议信息失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

    @PostMapping("addMeetingNotice")
    @ApiOperation(value = "添加会议通知信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    public MeetingNoticeResult addMeetingNotice(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            meetingNoticeService.addMeetingNotice(meetingNotice);
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("添加会议通知成功");
            logger.info("添加会议通知成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            logger.error("添加会议信息失败");
            meetingNoticeResult.setMsg("添加会议信息失败");
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "修改会议通知信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("updateMeetingNotice")
    public MeetingNoticeResult updateMeetingNotice(@RequestBody  MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            meetingNoticeService.updateMeetingNotice(meetingNotice);
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("修改会议信息成功");
            logger.info("修改会议信息成功");
            return  meetingNoticeResult;
        } catch (Exception e) {
            logger.error("修改会议信息失败");
            meetingNoticeResult.setMsg("修改会议信息失败");
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "通过会议名字查询会议通知ID")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query",name = "meetingName",value = "会议名字",dataType = "String",required = true)
    })
    @PostMapping("findNoticeIdByMeetingName")
    public MeetingNoticeResult findNoticeIdByMeetingName(String meetingName){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            int noticeId = meetingNoticeService.findNoticeIdByMeetingName(meetingName);
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("通过会议名字查询会议通知ID成功");
            logger.info("通过会议名字查询会议通知ID成功"+noticeId);
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("通过会议名字查询会议通知ID失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }
}
