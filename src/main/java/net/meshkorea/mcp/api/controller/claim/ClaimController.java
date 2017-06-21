package net.meshkorea.mcp.api.controller.claim;

import com.vroong.lastmile.api.client.ApiException;
import net.meshkorea.mcp.api.domain.model.claim.*;
import net.meshkorea.mcp.api.service.claim.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by reverof on 2017. 3. 24..
 */
@RestController
@RequestMapping(value = "/v1/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    /*
    1. 리스트 조회
    7. 배송오더 조회(클레임배송오더 매핑)
    8. 클레임 사유 코드
     */
    //detail Api 완료
    @GetMapping(value = "/{claimNo}")
    public ClaimDetailResponse getClaimDetail(@PathVariable Long claimNo) throws ApiException {
        return claimService.getClaimDetail(claimNo);
    }

    //List Api
    @PostMapping(value = "/findClaims")
    public ClaimListResponse findClaims(@RequestBody ClaimSearchDto claimSearchDto) throws ApiException {
        return claimService.findClaims(claimSearchDto);
    }

    //insert description
    @PutMapping("/description")
    public UpdateClaimDescriptionResponse updateDescription(@RequestBody UpdateClaimDescriptionRequest request) {
        return claimService.updateDescription(request);
    }

    //create claim
    @PostMapping("/createClaim")
    public CreateClaimResponse createClaim(@RequestBody CreateClaimRequest request) throws ApiException {
        return claimService.createClaim(request);
    }

    @PutMapping("/updateClaim")
    public UpdateClaimResponse updateClaim(@RequestBody UpdateClaimRequest request) {
        return claimService.updateClaim(request);
    }

    @PutMapping("/updateAdjustment")
    public UpdateClaimAdjustmentResponse updateClaimAdjustment(@RequestBody UpdateClaimAdjustmentRequest request) {
        return claimService.updateClaimAdjustment(request);
    }

    @GetMapping("/getClaimReasonCode")
    public ClaimReasonCodeResponse getClaimReasonCode() {
        return claimService.getClaimReasonCode();
    }

    @GetMapping("/getClaimCode")
    public ClaimCodeResponse getClaimCode(String code) {
        return claimService.getClaimCode(code);
    }
    //2. 클레임 parent 사유 코드 api
    //@GetMapping("/listParentCode")


    //3. 클레임 child 사유 코드 api
    //@GetMapping("/listChildCode")

}
