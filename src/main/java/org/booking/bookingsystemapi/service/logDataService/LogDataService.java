package org.booking.bookingsystemapi.service.logDataService;

import org.booking.bookingsystemapi.domain.LogData;
import org.booking.bookingsystemapi.repository.LogDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogDataService {

    private LogDataRepository logDataRepository;

    public LogDataService(LogDataRepository logDataRepository) {
        this.logDataRepository = logDataRepository;
    }

    public void saveLogData(String logType, String action) {
        LogData logData = new LogData(
                LocalDateTime.now(),
                logType,
                action
        );
        logDataRepository.save(logData);
    }
}
