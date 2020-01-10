package com.juju.result;

import com.juju.po.MeetingNotice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingNoticeResult extends BaseResult {
    private MeetingNotice meetingNotice;
    private List<MeetingNotice> meetingNotices;
}
