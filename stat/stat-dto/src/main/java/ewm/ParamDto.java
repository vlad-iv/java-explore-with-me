package ewm;

import lombok.Builder;

@Builder
public record ParamDto(String uri) {
    public ParamDto {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("Uri cannot be null or empty");
        }
    }
}
