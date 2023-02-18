package com.mztalk.loginservice.service;

import com.mztalk.loginservice.domain.dto.Result;

public interface SelectReportService {
    Result<?> getAllReport();

    Result<?> getEditList(long userNo);
}
