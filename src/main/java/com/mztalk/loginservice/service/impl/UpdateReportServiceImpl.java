package com.mztalk.loginservice.service.impl;

import com.mztalk.loginservice.repository.ReportRepository;
import com.mztalk.loginservice.user.repository.UserRepository;
import com.mztalk.loginservice.service.UpdateReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateReportServiceImpl implements UpdateReportService {

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;
    @Override
    public long postReport(long boardId, long userId, String serviceName) {
        userRepository.updateReportCount(userId);
        userRepository.commit();
        return 1L;
    }
}
