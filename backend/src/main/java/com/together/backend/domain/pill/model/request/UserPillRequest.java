package com.together.backend.domain.pill.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserPillRequest {
    private String option;
    private String startDate;
}
