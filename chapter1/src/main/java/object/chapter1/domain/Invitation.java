package object.chapter1.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Invitation {
    private LocalDateTime when;
}
