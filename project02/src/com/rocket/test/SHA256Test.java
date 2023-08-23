package com.rocket.test;

import com.rocket.util.SHA256;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String pwd = "1234";
        String cryPwd = SHA256.encrypt(pwd);
        System.out.println("입력된 비밀번호 : " + pwd);
        System.out.println("암호화된 비밀번호 : " + cryPwd);
        System.out.println("암호화된 비밀번호 글자수 : " + cryPwd.length());

        Scanner sc = new Scanner(System.in);
        System.out.print("암호 입력 : ");
        String inPwd = sc.nextLine();
        String inCryPwd = SHA256.encrypt(inPwd);
        if (cryPwd.equals(inCryPwd)) {
            System.out.println("로그인 성공");
            System.out.println("입력된 암호와 일치합니다~");
        } else {
            System.out.println("로그인 실패");
            System.out.println("비밀번호를 다시 한 번 확인해주세요");
        }
    }

}
