package com.aaa.Orc;
import java.util.Map;

public class OrcTest {


    public static void main(String[] args) {

        Authentication authentication = new Authentication();

        Map<String, Object> map = authentication.map("C:\\Users\\86159\\Desktop\\Images\\QQ图片20200821084322.jpg");

        System.out.println(map);
    }
}
