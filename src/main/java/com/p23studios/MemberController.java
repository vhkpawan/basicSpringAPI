package com.p23studios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public String addNewMember(@RequestBody Member member){
        memberService.addNewMember(member);
        return "Success";
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("{id}")
    public Member getMemberById(@PathVariable int id){
        return memberService.getMemberById(id);
    }

    @DeleteMapping("{id}")
    public String deleteMemberById(@PathVariable int id){
        memberService.deleteMemberById(id);
        return "Member with id: " + id + " was deleted successfully";
    }

    @PatchMapping("{id}")
    public String updateMemberById(@PathVariable int id, @RequestBody Member member){
        memberService.updateMemberById(id,member);
        return "Member with id: " + id + " was updated successfully";
    }
}
