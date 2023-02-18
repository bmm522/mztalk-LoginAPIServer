package com.mztalk.loginservice.repository;

import com.mztalk.loginservice.domain.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long>, ReportCustomRepository {
    List<Report> findAllByReportStatus(String Y);
}
