package com.together.backend.domain.calendar.service;

import com.together.backend.domain.calendar.model.entity.IntakeRecord;
import com.together.backend.domain.calendar.model.entity.IntakeType;
import com.together.backend.domain.calendar.repository.IntakeRecordRepository;
import com.together.backend.domain.pill.model.entity.IntakeOption;
import com.together.backend.domain.pill.model.entity.UserPill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class IntakeRecordInitService {
    private final IntakeRecordRepository intakeRecordRepository;

    // 복용 시작일, 복용 옵션, 복용 시간, userPill을 입력 받아 초기 복용기록 생성
    public void createInitialRecords(LocalDate startDate, IntakeOption option,  UserPill userPill) {
//        int totalDays = option.getRealDays() + option.getFakeDays() + option.getBreakDays();
        int totalDays = option.getRealDays() + option.getFakeDays();

        for(int i = 0; i < totalDays; i++) {
            // 시작일로부터 +i일
            LocalDate date = startDate.plusDays(i);

            IntakeType type;
            if(i < option.getRealDays()) {
                type = IntakeType.REAL;
            } else if(i < option.getRealDays() + option.getFakeDays()) {
                type = IntakeType.FAKE;
            } else {
                type = IntakeType.BREAK;
            }

            IntakeRecord record = IntakeRecord.builder()
                    .userPill(userPill)
                    .intakeDate(date)
                    .isTaken(false) // 초기값
                    .type(type)
                    .build();
            intakeRecordRepository.save(record);
        }

    }
}
