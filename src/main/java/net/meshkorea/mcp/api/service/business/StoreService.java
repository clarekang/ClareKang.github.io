package net.meshkorea.mcp.api.service.business;

import com.meshprime.api.client.ApiException;
import com.meshprime.api.client.model.*;
import com.meshprime.intra.api.IntraBusinessClientsApi;
import com.meshprime.intra.api.IntraRegionsApi;
import com.meshprime.intra.api.IntraStoresApi;
import com.meshprime.intra.service.auth.IntraTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chaelee on 2017. 3. 23..
 */
@Service
public class StoreService {

    @Autowired
    IntraTokenService intraTokenService;

    @Autowired
    IntraStoresApi intraStoresApi;

    @Autowired
    IntraBusinessClientsApi intraBusinessClientsApi;

    @Autowired
    IntraRegionsApi intraRegionsApi;

    public List<StoreManagementDepartment> getStoreManagementDepartmentList() throws Exception {
        return intraStoresApi.getStoreManagementDepartmentsList(intraTokenService.getAuthToken());
    }

    public StoresResult listStores(String storeType, String storeCertificationStatus, String storeOperatingStatus,
                                   String storeName, String clientName, String storePhone, String storeAddress,
                                   String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId,
                                   Integer size, Integer page) throws Exception {
        return intraStoresApi.listStores(intraTokenService.getAuthToken(), storeType, storeCertificationStatus,
            storeOperatingStatus, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId,
            vroongMonitoringPartnerId, size, page);
    }

    public List<MonitoringPartner> listPartners() throws Exception {
        return intraStoresApi.listMonitoringPartners(intraTokenService.getAuthToken());
    }

    public List<BusinessClientShort> getBusinessClientList(String clientType) throws Exception {
        return intraBusinessClientsApi.getBusinessClientList(intraTokenService.getAuthToken(), clientType);
    }

    public List<VroongServicePricingType> listVroongServicePricingTypes() throws Exception {
        return intraStoresApi.listVroongServicePricingTypes(intraTokenService.getAuthToken());
    }

    public List<StoreSalesDepartment> getSalesDepartments() throws Exception {
        return intraStoresApi.salesDepartments(intraTokenService.getAuthToken());
    }

    public StoreResponse createIndividualStore(CreateIndividualStoreRequest req) throws Exception {
        return intraStoresApi.createIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public StoreResponse createFranchiseIndividualStore(CreateFranchiseIndividualStoreRequest req) throws Exception {
        return intraStoresApi.createFranchiseIndividualStore(intraTokenService.getAuthToken(), req);
    }

    public StoreResponse createFranchiseCorporateStore(CreateFranchiseCorporateStoreRequest req) throws Exception {
        return intraStoresApi.createFranchiseCorporateStore(intraTokenService.getAuthToken(), req);
    }

    public Boolean checkStoreUserExists(CheckStoreUsersRequest req) throws Exception {
        return intraStoresApi.checkStoreUserExists(intraTokenService.getAuthToken(), req);
    }

    public Store getStore(String id) throws Exception {
        return intraStoresApi.getStore(intraTokenService.getAuthToken(), id);
    }

    public StoreRequest updateStore(String id, StoreRequest store) throws Exception {
        return intraStoresApi.updateStore(intraTokenService.getAuthToken(), id, store);
    }

    public List<StoreList> getStoreList(String storeType, String storeName, String clientName, String storePhone, String storeAddress,
                                        String tag, Integer storeManagementDepartmentId, Integer vroongMonitoringPartnerId) throws ApiException {
        return intraStoresApi.getStoreList(intraTokenService.getAuthToken(), storeType, storeName, clientName, storePhone, storeAddress, tag, storeManagementDepartmentId, vroongMonitoringPartnerId);
    }

    public UpdatePricingPolicyResponse updateStorePricingPolicy(Integer id, PricingPolicy pricingPolicy) throws ApiException {
        return intraStoresApi.updateStorePricingPolicy(intraTokenService.getAuthToken(), id.toString(), pricingPolicy);
        // return new PricingPolicy();
    }

    public List<Regions> getDetailRegions(String detail) throws ApiException {
        return intraRegionsApi.listRegions(intraTokenService.getAuthToken(),"","", detail, 0, "0");
    }

    public List<Regions> updateStoreRegions(Integer id, UpdateStoreRegionsRequest req) throws ApiException {
        return intraStoresApi.updateStoreRegions(intraTokenService.getAuthToken(), id, req);
    }

    public SubscriptionPlan updateSubscriptionPlan(String id, SubscriptionPlan req) throws ApiException {
        return intraStoresApi.updateSubscriptionsPlan(intraTokenService.getAuthToken(), id, req);
    }

    public Store updateAdminMemo(String id, AdminMemoRequest req) throws ApiException {
        return intraStoresApi.addStoreAdminMemo(intraTokenService.getAuthToken(), id, req);
    }

    public BranchCodesResponse createBranchCode(String id, CreateApiBranchCodeRequest req) throws ApiException {
        return intraStoresApi.createStoreBranchCode(intraTokenService.getAuthToken(), id, req);
    }

    public BranchCodesResponse getBranchCode(String id) throws ApiException {
        return intraStoresApi.getStoreBranchCode(intraTokenService.getAuthToken(), id);
    }

    public Store updateStoreCertificationStatus(String id, ChangeStoreCertificationStatusRequest req) throws ApiException {
        return intraStoresApi.changeStoreCertificationStatus(intraTokenService.getAuthToken(), id, req);
    }

    public Store updateStoreOperatingStatus(String id, ChangeStoreOperatingStatusRequest req) throws ApiException {
        return intraStoresApi.changeStoreOperatingStatus(intraTokenService.getAuthToken(), id, req);
    }

    public Store addSubscriptionAdminMemo(String id, SubscriptionAdminMemo req) throws ApiException {
        System.out.println(id + ", "  + req.toString());
        return intraStoresApi.addSubscriptionAdminMemo(intraTokenService.getAuthToken(), id, req);
    }


}
