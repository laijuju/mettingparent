package com.juju.result;

import com.juju.po.MeetingNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingNewsResult extends BaseResult{
    private List<MeetingNews> meetingNewsList;
    private MeetingNews meetingNews;
}
