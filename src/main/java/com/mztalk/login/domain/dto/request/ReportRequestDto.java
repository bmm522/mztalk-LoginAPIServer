package com.mztalk.login.domain.dto.request;

import com.mztalk.login.domain.entity.Report;
import com.mztalk.login.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequestDto {

    private String reportTitle;
    private String reportContent;
    private String boardId;

    private String serviceName;
    private String userNo;

    public Report toEntity(User user){
        String path = "";
        switch (serviceName){
            case "bung" : path="http://127.0.0.1:5501/bung-service-detail.html"; break;
            case "auction" : path="http://127.0.0.1:5501/auctionDetail.html"; break;
            case "mentor" : path="null"; break;
        }

        return Report.builder()
                .reportTitle(reportTitle)
                .reportContent(reportContent)
                .boardId(boardId)
                .serviceName(serviceName)
                .user(user)
                .path(path)
                .reportStatus("Y")
                .build();
    }
}
