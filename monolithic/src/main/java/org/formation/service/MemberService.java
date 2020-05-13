package org.formation.service;

import org.formation.model.Member;
import org.formation.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public Member registerMember(Member m) {
		return memberRepository.save(m);
	}
}
