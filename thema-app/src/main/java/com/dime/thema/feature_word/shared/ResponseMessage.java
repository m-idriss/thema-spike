package com.dime.thema.feature_word.shared;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseMessage {
    String message;
    Date timestamp;
    Integer code;

}
