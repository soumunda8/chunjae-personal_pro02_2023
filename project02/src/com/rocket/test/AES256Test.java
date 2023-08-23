package com.rocket.test;

import com.rocket.util.AES256;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

public class AES256Test {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, InvalidKeySpecException, InvalidParameterSpecException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        String oriText = "1234";
        String key = "%02x";

        System.out.println("원래 데이터 : " + oriText);
        System.out.println("MD5 : " + AES256.md5(oriText));
        System.out.println("SHA256 : " + AES256.sha256(oriText));

        // 비밀번호 암호는 AES256 사용하기 -> 암호화와 복호화가 모두 가능하기 때문!
        // 암호화
        String aes = AES256.encryptAES256(oriText, key);
        System.out.println("AES256 암호화 : " + aes);
        // 복호화
        System.out.println("AES256 복호화 : " + AES256.decryptAES256(aes, key));

    }

}
