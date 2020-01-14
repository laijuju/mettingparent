package com.juju.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class MeetingNews {
    private int id;                     //会议新闻ID
    private String meetingName;         //会议新闻名称
    private String meetingIntroduce;    //会议新闻介绍
    private String meetingDetails;      //会议新闻详情
    private int type;                   //会议新闻类型
    private String meetingNewPio;       //会议新闻图片
}
