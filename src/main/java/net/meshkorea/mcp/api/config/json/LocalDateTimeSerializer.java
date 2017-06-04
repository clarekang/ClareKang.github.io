package net.meshkorea.mcp.api.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Component
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException, DateTimeException {
        String result = StringUtils.EMPTY;
        try {
            result = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value);
        } catch (DateTimeException e) {
            result = DateTimeFormatter.ISO_INSTANT.format(value);
        }
        gen.writeString(result);
    }
}
