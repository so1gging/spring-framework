package com.mvc.upgrade.biz;

import com.mvc.upgrade.model.dto.MemberDto;

public interface MemberBiz {
	public MemberDto login(MemberDto dto);

	public int insert(MemberDto dto);
}
