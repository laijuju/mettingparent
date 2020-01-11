package com.juju.control;

import com.juju.po.MeetingNotice;
import com.juju.result.MeetingNoticeResult;
import com.juju.service.IMeetingAgendaService;
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
@Api(value = "会议议程功能测试接口",description = "会议议程功能测试接口")
public class MeetingAgendaController {

    @Autowired
    private IMeetingAgendaService meetingAgendaService;
    @Autowired
    private IMeetingNoticeService meetingNoticeService;
    
    Logger logger = Logger.getLogger(MeetingAgendaController.class);
    
    @ApiOperation(value = "查询所有的会议议程")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @GetMapping("findMeetingAgendaAll")
    public MeetingNoticeResult findMeetingAgendaAll(){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            List<MeetingNotice> meetingAgendas = meetingAgendaService.findMeetingAgendaAll();
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("查询所有会议议程成功");
            meetingNoticeResult.setMeetingNotices(meetingAgendas);
            logger.info("查询所有会议议程成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("查询所有会议议程失败："+e.getMessage());
            logger.error("查询所有会议议程失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "通过Id查询会议议程")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("findMeetingAgendaById")
    public MeetingNoticeResult findMeetingAgendaById(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            MeetingNotice meeting = meetingAgendaService.findMeetingAgendaById(meetingNotice.getId());
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("通过Id查询议程成功");
            logger.info("通过Id查询议程成功");
            meetingNoticeResult.setMeetingNotice(meeting);
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("通过Id查询失败："+e.getMessage());
            logger.error("通过Id查询失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "添加会议议程")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("addMeetingAgenda")
    public MeetingNoticeResult addMeetingAgenda(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            int noticeId = meetingNoticeService.findNoticeIdByMeetingName(meetingNotice.getMeetingName());
            meetingNotice.setId(noticeId);
            meetingAgendaService.addMeetingAgenda(meetingNotice);
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("添加会议议程成功");
            logger.info("添加会议议程成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("添加会议议程失败："+e.getMessage());
            logger.error("添加会议议程失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "删除会议议程")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("deleteMeetingAgenda")
    public MeetingNoticeResult deleteMeetingAgenda(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            meetingAgendaService.deleteMeetingAgenda(meetingNotice.getId());
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("删除会议议程成功");
            logger.info("删除会议议程成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("删除会议议程失败"+e.getMessage());
            logger.error("删除会议议程失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

    @ApiOperation(value = "修改会议议程信息")
    @ApiImplicitParam(paramType = "header", name = "token", value = "用户token", dataType = "String", required = true)
    @PostMapping("updateMeetingAgenda")
    public MeetingNoticeResult updateMeetingAgenda(@RequestBody MeetingNotice meetingNotice){
        MeetingNoticeResult meetingNoticeResult = new MeetingNoticeResult();
        meetingNoticeResult.setState(0);
        try {
            meetingAgendaService.updateMeetingAgenda(meetingNotice);
            meetingNoticeResult.setState(1);
            meetingNoticeResult.setMsg("修改议程信息成功");
            logger.info("修改议程信息成功");
            return meetingNoticeResult;
        } catch (Exception e) {
            meetingNoticeResult.setMsg("修改议程信息失败："+e.getMessage());
            logger.error("修改议程信息失败："+e.getMessage());
            return meetingNoticeResult;
        }
    }

}
