package com.p23studios;

import org.springframework.stereotype.Service;
import java.util.List;


// this is now a bean that spring will handle
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public void addNewMember(Member member) {
        // need validation before saving
        memberRepository.save(member);
    }

    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member not found with id " + id)
        );
    }

    public void deleteMemberById(int id) {
        if(memberRepository.existsById(id)){
            memberRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Member not found with id " + id);
        }
    }

    public void updateMemberById(int id, Member member) {
        if(memberRepository.existsById(id)){
            Member existing = memberRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("Member not found with id " + id)
            );
            existing.setFirstName(member.getFirstName());
            existing.setLastName(member.getLastName());
            existing.setRole(member.getRole());
            memberRepository.save(existing);
        }else{
            throw new IllegalArgumentException("Member not found with id " + id + "Or could not save new info");
        }
    }
}
