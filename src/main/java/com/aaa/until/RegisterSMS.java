package com.aaa.until;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.digest.DigestUtil;

import java.util.Map;

/**
 * 注册时发送的短信
 */
public class RegisterSMS implements BaseSMS {

    private String template = "【imooc】尊敬的客户，您的验证码为{code}，请于{time}分钟内正确输入。 如非本人操作，请忽略此短信。";

    /**
     * 替换 template 中的 {code} 或其他占位符
     *
     * @param replace 被替换着者
     * @param value   值
     * @return 替换之后的 template
     */
    private void replace(String replace, String value) {
        this.template = template.replace(replace, value);
    }

    @Override
    public String init(Map<String, String> params, String... phone) {

        StringBuffer request = new StringBuffer();

        request.append(url).append("?");
        request.append("u=").append(username).append("&");
        request.append("p=").append(DigestUtil.md5Hex(password)).append("&");
        request.append("m=").append(ArrayUtil.join(phone, ",")).append("&");

        params.entrySet().forEach(entry -> {
            this.replace("{" + entry.getKey() + "}", entry.getValue());
        });

        request.append("c=").append(URLUtil.encode(template, "UTF-8"));

        return request.toString();
    }
}
