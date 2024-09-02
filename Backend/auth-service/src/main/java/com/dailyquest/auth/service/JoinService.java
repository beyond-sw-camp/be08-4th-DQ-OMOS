package com.dailyquest.auth.service;

import com.dailyquest.auth.dto.form.JoinDTO;
import com.dailyquest.auth.entity.Member;
import com.dailyquest.auth.entity.enums.Role;
import com.dailyquest.auth.entity.enums.Status;
import com.dailyquest.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String join(JoinDTO joinDTO) throws Exception {
        String email = joinDTO.getEmail();

        // Check if the email already exists
        if (userRepository.existsByEmail(email)) {
            if (!userRepository.findByEmail(email).get().getStatus().equals(Status.N)) {
                throw new Exception("존재하는 회원입니다.");
            } else {
                userRepository.deleteById(userRepository.findByEmail(email).get().getMemberId());
            }
        }

        // Proceed with the registration
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        member.setName(joinDTO.getName());
        member.setStatus(Status.Y);
        member.setRole(Role.ROLE_USER);

        userRepository.save(member);
        return member.getName() + "님 환영합니다!";
    }

}
