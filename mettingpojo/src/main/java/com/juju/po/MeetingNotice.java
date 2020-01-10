package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class MeetingNotice {
    private int id;                     //会议通知ID
    private String meetingName;         //会议名字
    private Date meetingTime;           //会议召开时间
    private String meetingAddress;      //会议召开地址
}
