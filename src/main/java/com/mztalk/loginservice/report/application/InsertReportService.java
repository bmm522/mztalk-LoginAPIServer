package com.mztalk.loginservice.report.application;

import com.mztalk.loginservice.domain.dto.request.ReportRequestDto;

public interface InsertReportService {
    long insertReport(ReportRequestDto reportRequestDto);
}
