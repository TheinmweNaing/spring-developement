package com.team.fine.repo.query;

import java.util.Map;

public interface SimpleQuery {

	String query();

	Map<String, Object> params();
}
