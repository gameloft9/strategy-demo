package com.gameloft9.demo.member;

/**
 * 工厂类
 * Created by gameloft9 on 2019/8/9.
 */
public class MemberFactory {

    public IMember getMember(double store){
        IMember member = null;

        if(store < 500){
            member = new PrimitiveMember();
        }else if(store < 1000){
            member = new MiddleMember();
        }else if(store >= 1000){
            member = new HighMember();
        }

        return member;
    }
}
