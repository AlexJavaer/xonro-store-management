package com.jeesite.modules.base.member.service;


import com.jeesite.common.lang.ExceptionUtils;
import com.jeesite.common.lang.ObjectUtils;
import com.jeesite.common.mapper.JsonMapper;
import com.jeesite.common.msg.SmsUtils;
import com.jeesite.common.service.BaseService;
import com.jeesite.modules.msg.entity.MsgPush;
import com.jeesite.modules.msg.entity.content.SmsMsgContent;
import com.jeesite.modules.msg.send.MsgSendService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@SuppressWarnings("all")
public class CustomSmsSendService  extends BaseService implements MsgSendService{
    @Override
    public void sendMessage(MsgPush msgPush) {
        try {
            //发送短信
            SmsMsgContent content = msgPush.parseMsgContent(SmsMsgContent.class);
            String result = SmsUtils.send(content.getContent(),msgPush.getReceiveCode());
            Map<String, Object> map = JsonMapper.fromJson(result, Map.class);

            //发送成功
            if(ObjectUtils.toInteger(map.get("result")) == 0){
                msgPush.setPushStatus(MsgPush.PUSH_STATUS_SUCCESS);
                msgPush.addPushReturnContent(result);
            }else{
                //发送失败
                throw new RuntimeException(result);
            }
        }catch (Exception ex){
            logger.error("发送短信失败！",ex);
            msgPush.setPushStatus(MsgPush.PUSH_STATUS_FAIL);
            msgPush.addPushReturnContent(ExceptionUtils.getStackTraceAsString(ex));
        }
    }
}
