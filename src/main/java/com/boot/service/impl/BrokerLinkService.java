package com.boot.service.impl;

import com.boot.dao.BrokerLinkMapper;
import com.boot.domain.BrokerLink;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author l.tian@aftership.com
 * @date 2020/6/8
 */
@Service
public class BrokerLinkService {

    //private static final Pattern EMAIL_PATTERN = Pattern.compile("^(?:(?:(?:(?:[a-zA-Z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])+(?:\\.([a-zA-Z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])+)*)|(?:(?:\\x22)(?:(?:(?:(?:\\x20|\\x09)*(?:\\x0d\\x0a))?(?:\\x20|\\x09)+)?(?:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])|(?:(?:[\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}]))))*(?:(?:(?:\\x20|\\x09)*(?:\\x0d\\x0a))?(\\x20|\\x09)+)?(?:\\x22))))@(?:(?:(?:[a-zA-Z]|\\d|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])|(?:(?:[a-zA-Z]|\\d|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])(?:[a-zA-Z]|\\d|-|\\.|~|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])*(?:[a-zA-Z]|\\d|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])))\\.)+(?:(?:[a-zA-Z]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])|(?:(?:[a-zA-Z]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])(?:[a-zA-Z]|\\d|-|\\.|~|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])*(?:[a-zA-Z]|[\\x{00A0}-\\x{D7FF}\\x{F900}-\\x{FDCF}\\x{FDF0}-\\x{FFEF}])))\\.?$");

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9!#$%&'+=?^_`{|}~-]+(.[A-Za-z0-9!#$%&'+=?^_`{|}~-]+)*@([A-Za-z0-9]+(?:-[A-Za-z0-9]+)?.)+[A-Za-z0-9]+(-[A-Za-z0-9]+)?$");
    @Resource
    BrokerLinkMapper mapper;


    public void getBrokerLink(){
       //1.查出所有 Shopify 的 broker link
        List<BrokerLink> list = mapper.getBrokerLink();
        System.out.println(list.size());
        Map<String,Integer> storeMap = new HashMap();
        Map<String,String> linkMap = new HashMap();
        Map needDeleteStoreMap = new HashMap();
        for(BrokerLink link:list){
            if(link!=null&&link.getIdentityProvider()!=null&&link.getIdentityProvider().contains(":")){

                //拿到所有的 key 为 identityProvider&brokerUserId, value 为 userId 的数据
                linkMap.put(link.getIdentityProvider()+"&"+link.getBrokerUserId(),link.getUserId());
                String key = link.getIdentityProvider().split(":")[1]+"&"+link.getBrokerUserId();
                if(storeMap.get(key)!=null){
                    //拿到同一个店铺同一个人拥有的 broker link 的数量
                    storeMap.put(key,storeMap.get(key)+1);
                }else {
                    storeMap.put(key,1);
                }
            }
        }
        //System.out.println("storeMap:"+storeMap);
        //System.out.println("linkMap:"+linkMap);
        for (Map.Entry<String, Integer> entry : storeMap.entrySet()) {
            if(entry.getValue()>1){
                String checkKey1 = "shopify:"+entry.getKey();
                String checkKey2 = "shopify-automizely-messages:"+entry.getKey();
                String checkKey3 = "shopify-returnscenter:"+entry.getKey();
                //System.out.println("checkKey1:"+checkKey1+",checkKey2:"+checkKey2+"checkKey3:"+checkKey3);
                String userId1 = linkMap.get(checkKey1);
                String userId2 = linkMap.get(checkKey2);
                String userId3 = linkMap.get(checkKey3);
                //System.out.println("userId1:"+userId1+",userId2:"+userId2+"userId3:"+userId3);
                Boolean needDelete = false;
                if(userId1 !=null){
                    if(userId2!=null&&!userId1.equalsIgnoreCase(userId2)){
                        needDelete = true;
                    }
                }else {
                    if(userId2!=null && userId3!=null &&!userId2.equalsIgnoreCase(userId3)){
                        needDelete = true;
                    }
                }
                if(needDelete){
                    needDeleteStoreMap.put(entry.getKey(),entry.getValue());
                    String storeName = entry.getKey().split("&")[0];
                    String brokerUserId = entry.getKey().split("&")[1];
                    System.out.println("select IDENTITY_PROVIDER,BROKER_USERNAME,USER_ID from BROKER_LINK where BROKER_USER_ID = '"+brokerUserId+"' and IDENTITY_PROVIDER LIKE '%"+storeName+"';");
                }
            }
        }
        //System.out.println(needDeleteStoreMap);
        System.out.println("-------:"+needDeleteStoreMap.size());
    }
     public void checkEmail(){
         List<BrokerLink> list = mapper.getBrokerLink();
         BrokerLink brokerLink = new BrokerLink();
         brokerLink.setBrokerUsername("ds.chen_123@asdssssssssf.comaaaaaaaaaaaaaaa");
         BrokerLink brokerLink1 = new BrokerLink();
         brokerLink1.setBrokerUsername("ds.chen_123@asdsssssssssssssssssssssssssf.com");
         list.add(brokerLink);
         list.add(brokerLink1);
         int count = 0;
         Long beginTime = System.currentTimeMillis();
         for(BrokerLink link:list){
             if(link!=null&&link.getBrokerUsername()!=null){
                if(!isEmailValid(link.getBrokerUsername())){
                    System.out.println(link.getBrokerUsername());
                    count++;
                }
             }
         }
         System.out.println("total:"+list.size()+",not pass count:"+count+",costTime:"+(System.currentTimeMillis()-beginTime));
     }

    public static boolean isEmailValid(String email) {
       return EmailValidator.getInstance().isValid(email);
        //return EMAIL_PATTERN.matcher(email).matches();
    }
}
