package com.mztalk.loginservice.report.repository;

import com.mztalk.loginservice.domain.entity.Report;

import java.util.List;

public interface ReportCustomRepository {
    long postReport(long boardId, long userId, String serviceName);

    List<Report> getEditListOfUserNo(long userNo);
}
