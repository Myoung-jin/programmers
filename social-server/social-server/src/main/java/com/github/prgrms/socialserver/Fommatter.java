package com.github.prgrms.socialserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.prgrms.socialserver.domain.Users;
import com.google.gson.Gson;

public class Fommatter {
	ObjectMapper objectMapper;
	Gson gson;

	public Fommatter() {
		objectMapper = new ObjectMapper();
		gson = new Gson();
	}

	public void format_jackson(Object obj) throws JsonProcessingException {
		System.out.println("==Jackson==");

		String mapperValue = objectMapper.writeValueAsString(obj);
		System.out.println("toJson:" + mapperValue);

		Users users = objectMapper.readValue(mapperValue, Users.class);
		System.out.println("fromJson:" + users);
	}

	public void format_gson(Object obj) {
		System.out.println("== Gson ==");
		String mappedValue = gson.toJson(obj);
		System.out.println("toJson : " + mappedValue);

		// format to POJO
		Users users = gson.fromJson(mappedValue, Users.class);
		System.out.println("fromJson : " + users);
	}
}
