package net.meshkorea.mcp.api.domain.model.claim;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by reverof on 2017. 4. 13..
 */
@Getter
@Setter
@ToString
public class Claim {

    private Long claimNo;

    private String statusCode;

    private String typeCode;

    private String requestCode;

    private String causeCode;

    private Float customerBlame;

    private Float storeBlame;

    private Float partnerBlame;

    private Float meshBlame;

    private Float noneBlame;

    private String creator;

    private Date createDt;

    private String updater;

    private Date updateDt;

    private Long orderId;

    private Long claimOrderId;

    private String orderNumber;

    private String claimOrderNumber;
}
