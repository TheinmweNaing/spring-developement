package com.team.fine.repo.query;

public class PageRequest implements Pageable {
	
	private int offset;
	private int limit;
	
	private PageRequest(int offset, int limit) {
		super();
		this.offset = offset;
		this.limit = limit;
	}

	public static final Pageable of(int offset, int limit) {
		return new PageRequest(offset, limit);
	}

	@Override
	public int offset() {
		return offset;
	}

	@Override
	public int limit() {
		return limit;
	}

}
