package com.gameloft9.demo.member;

/**
 * 错误的示范案例，并没有消除if-else
 * Created by gameloft9 on 2019/8/9.
 */
public class Client {

    public static void main(String[] args) {

        IMember member = null;

        double store = 1000;

        double money = 100;

        member = new MemberFactory().getMember(store);

        member.charge(money);
    }
}
