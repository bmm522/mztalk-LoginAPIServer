package com.mztalk.loginservice.domain.dto.response;

import com.mztalk.loginservice.user.application.login.dto.response.ServiceUserInfoResponseDto;
import com.mztalk.loginservice.domain.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportResponseDto {

    private String reportTitle;
    private String reportContent;
    private String boardId;
    private String serviceName;
    private ServiceUserInfoResponseDto user;
    private String path;

    private String reportStatus;

    public ReportResponseDto(Report report, ServiceUserInfoResponseDto serviceUserInfoResponseDto){
        this.reportTitle = report.getReportTitle();
        this.reportContent = report.getReportContent();
        this.boardId = report.getBoardId();
        this.serviceName = report.getServiceName();
        this.user = serviceUserInfoResponseDto;
        this.path = report.getPath();
        this.reportStatus=report.getReportStatus();
    }
}
