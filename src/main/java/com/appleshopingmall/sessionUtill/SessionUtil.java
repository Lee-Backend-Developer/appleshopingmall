package com.appleshopingmall.sessionUtill;

import com.appleshopingmall.member.MemberEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionUtil {

    private static final SessionUtil SESSION_UTIL = new SessionUtil();
    private static final String MEMBER_ID = "memberID";

    private SessionUtil(){}

    public static SessionUtil getSessionUtil() {
        return SESSION_UTIL;
    }

    // 로그인 성공시 세션 생성
    public void addSession(HttpSession httpSession, MemberEntity member){
        if(member.getPosition().equals("ADMIN")) httpSession.setAttribute("position", "ADMIN");
        httpSession.setAttribute("memberName", member.getMemberFirstname());
        httpSession.setAttribute(MEMBER_ID, member.getMemberID());
    }

    // 현재 접속자가 세션이 있는 사람이면 true, 없으면 false
    public boolean hasSession(HttpSession httpSession) {
        return (getMemberID(httpSession) != null);
    }

    // memberID 세션을 가져옴
    public Long getMemberID(HttpSession httpSession) {
        return (Long)httpSession.getAttribute(MEMBER_ID);
    }

}