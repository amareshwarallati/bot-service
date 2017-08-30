package com.wow.botservice.utils;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Used to serialize Java.sql.Timestamp, which is not a common JSON
 * type, so we have to create a custom serialize method;.
 *
 * @author
 * 
 */

@Component
public class JsonTimestampSerializer extends JsonSerializer<Timestamp>{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	
	@Override
	public void serialize(Timestamp ts, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if(ts == null){
			gen.writeString("Not Available");
			return;
		}
		String formattedDate = dateFormat.format(new Date(ts.getTime()));
		gen.writeString(formattedDate);
	}
}