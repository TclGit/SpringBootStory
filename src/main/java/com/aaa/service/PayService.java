package com.aaa.service;

import com.aaa.entity.AlipayBean;
import com.alipay.api.AlipayApiException;

public interface PayService {

    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}
