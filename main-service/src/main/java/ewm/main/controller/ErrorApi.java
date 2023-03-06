package ewm.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorApi {
    private final HttpStatus status; // статус

    private final String reason; // Наше описание ошибки

    private final String message; // e.getMessage()

    private final List<String> errors; // StackTrace

    public ErrorApi(HttpStatus status, String reason, String message, List<String> errors) {
        this.status = status;
        this.reason = reason;
        this.message = message;
        this.errors = errors;
    }
}
