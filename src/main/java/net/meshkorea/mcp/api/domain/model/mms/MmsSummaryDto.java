package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
@Setter
public class MmsSummaryDto {

    private Long mmsSummaryNo;

    private String mmsSender;

    private LocalDateTime mmsTransDate;

    private List<MmsGroupDto> mmsGroups;

}
