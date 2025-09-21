package com.p23studios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    @GetMapping
    public List<Member> getMembers(){
        return List.of(
                new Member(1,"Pawan","Harikrishnan","Admin"),
                new Member(2,"Frank","Enstien","Editor"),
                new Member(3,"Joseph","Stalin","Writer")
        );
    }
}
