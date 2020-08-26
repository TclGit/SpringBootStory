package com.aaa.Orc;

import java.util.Map;

/**
 * 图像识别接口
 */
public interface Config {

    String APP_ID = "22141781";

    String API_KEY = "ciwP2jPnDQey6O2IVhRN6sQv";

    String SECRET_KEY = "2BpKH2SZjcpKDGN5Y63e48GgxxdAkXaq";

    Map<String, Object> map(String imgUrl);
}
