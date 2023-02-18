package com.mztalk.loginservice.service.impl;

import com.mztalk.loginservice.domain.dto.request.ReportRequestDto;
import com.mztalk.loginservice.domain.entity.Report;
import com.mztalk.loginservice.repository.ReportRepository;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.service.InsertReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InsertReportServiceImpl implements InsertReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Override
    public long insertReport(ReportRequestDto reportRequestDto) {
        Report report = reportRequestDto.toEntity(userRepository.findById(Long.parseLong(reportRequestDto.getUserNo()))
                .orElseThrow(()->new NullPointerException("Not UserNo")));
        return reportRepository.save(report).getReportId();
    }
}
