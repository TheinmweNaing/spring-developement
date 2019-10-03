package com.team.fine;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateToTimestampSerializer extends StdSerializer<LocalDate> {

	private static final long serialVersionUID = 1L;

	protected LocalDateToTimestampSerializer() {
		super(LocalDate.class);
	}

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if (value != null) {
			long timeStamp = value.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
			gen.writeNumber(timeStamp);
		}
	}

}
