package com.court.management.service;

import com.court.management.request.ApproveRejectReq;
import com.court.management.response.SuccessResponse;

public interface ApproveRejectService {

    SuccessResponse approveReject(ApproveRejectReq approveRejectReq);

}
