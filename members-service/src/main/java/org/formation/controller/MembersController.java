package org.formation.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.formation.client.Courriel;
import org.formation.client.NotificationClient;
import org.formation.repository.Member;
import org.formation.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A RESTFul controller for accessing Member information.
 * 
 * @author Paul Chapman
 */
@RestController
public class MembersController {

	protected Logger logger = Logger.getLogger(MembersController.class.getName());
	protected MemberRepository memberRepository;
	protected NotificationClient notificationClient;

	/**
	 * Create an instance plugging in the respository of Members.
	 * 
	 * @param MemberRepository
	 *            An Member repository implementation.
	 */
	@Autowired
	public MembersController(MemberRepository memberRepository, NotificationClient notificationClient) {
		this.memberRepository = memberRepository;
		this.notificationClient = notificationClient;

		logger.info("MemberRepository says system has " + memberRepository.countMembers() + " Members");
	}

	/**
	 * Fetch an Member with the specified Member number.
	 * 
	 * @param MemberNumber
	 *            A numeric, 9 digit Member number.
	 * @return The Member if found.
	 * @throws MemberNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/Members/{memberId}")
	public Member byNumber(@PathVariable("memberId") long memberId) {

		logger.info("Members-service byNumber() invoked: " + memberId);
		Member member = memberRepository.findById(memberId);
		logger.info("Members-service byNumber() found: " + member);

		if (member == null)
			throw new MemberNotFoundException("" + memberId);
		else {
			return member;
		}
	}

	/**
	 * Fetch Members with the specified name. A partial case-insensitive match
	 * is supported. So <code>http://.../Members/owner/a</code> will find any
	 * Members with upper or lower case 'a' in their name.
	 * 
	 * @param partialName
	 * @return A non-null, non-empty set of Members.
	 * @throws MemberNotFoundException
	 *             If there are no matches at all.
	 */
	@RequestMapping("/Members/owner/{name}")
	public List<Member> byOwner(@PathVariable("name") String partialName) {
		logger.info(
				"Members-service byOwner() invoked: " + memberRepository.getClass().getName() + " for " + partialName);

		List<Member> members = memberRepository.findByNomContainingIgnoreCase(partialName);
		logger.info("Members-service byOwner() found: " + members);

		if (members == null || members.size() == 0)
			throw new MemberNotFoundException(partialName);
		else {
			return members;
		}

	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public Member authenticate(@Valid @RequestBody User user) {
		logger.info("Members-service authenticate() invoked: " + user);
		Member member = memberRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if (member == null)
			throw new MemberNotFoundException("" + user.getEmail());
		else {
			return member;
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public Member register(@Valid @RequestBody Member member) {
		member = memberRepository.save(member);
		
		Courriel email = new Courriel();
		email.setTo(member.getEmail());
		email.setSubject("Registration");
		email.setText("Welcome onboard !");

		notificationClient.sendSimple(email);
		
		return member;
	}
}
