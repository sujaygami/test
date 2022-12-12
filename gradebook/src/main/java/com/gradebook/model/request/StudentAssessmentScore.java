package com.gradebook.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class StudentAssessmentScore {
    private String courseId;
    @JsonProperty("userId")
    private String gbUserId;
    private String assessmentId;
    private Timestamp dtSubmitted;
    @JsonProperty("score")
    private Score score;
}
