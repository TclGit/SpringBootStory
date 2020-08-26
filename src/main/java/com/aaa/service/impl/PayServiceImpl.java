package com.aaa.service.impl;

import com.aaa.entity.AlipayBean;
import com.aaa.service.PayService;
import com.aaa.until.Alipay;
import com.alipay.api.AlipayApiException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }

}
