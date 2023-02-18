package com.mztalk.loginservice.service;

import com.mztalk.loginservice.domain.dto.request.ReportRequestDto;

public interface InsertReportService {
    long insertReport(ReportRequestDto reportRequestDto);
}
