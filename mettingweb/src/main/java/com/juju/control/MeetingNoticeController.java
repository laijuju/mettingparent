package com.juju.control;

import com.juju.po.MeetingNotice;
import com.juju.result.MeetingNoticeResult;
import com.juju.service.IMeetingNoticeService;
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
@Api(value = "会议通知功能借口测试", description = "会议通知功能借口测试")
public class MeetingNoticeController {

    Logger logger = Logger.getLogger(MeetingNoticeController.class);

    @Autowired
    private IMeetingNoticeService mettingNoticeService;

    @ApiOperation(value = "查看所有会议通知")
    @GetMapping("findAllMeetingNotice")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    public MeetingNoticeResult findAllMeetingNotice() {
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            List<MeetingNotice> allMeetingNotice = mettingNoticeService.findAllMeetingNotice();
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
            MeetingNotice meeting = mettingNoticeService.selectMeetingNoticeById(meetingNotice.getId());
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
            mettingNoticeService.deleteMeetingNoticeById(meetingNotice.getId());
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

}
