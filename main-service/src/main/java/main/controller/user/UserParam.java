package main.controller.user;

import lombok.Data;

@Data
public class UserParam {
	String param1;
	String param2;
	String param3;
	String param4;

	boolean isParam1() {
		return param1 != null;
	}

	{
		UserParam userParam = new UserParam();

		if (userParam.isParam1()) {
			"and param1 = :param1";
		}
	}
}
