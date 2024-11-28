package org.booking.bookingsystemapi.domain;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@lombok.Setter
@lombok.Getter
@lombok.EqualsAndHashCode
@lombok.ToString
@Document(collection = "logs")
public class LogData {
    @Id
    private String id;

    private LocalDateTime loggedTime;

    private String logType;

    private String action;

    public LogData(LocalDateTime loggedTime, String logType, String action) {
        this.loggedTime = loggedTime;
        this.logType = logType;
        this.action = action;
    }

    public LogData() {
    }

}
