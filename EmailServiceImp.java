package com;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.jws.WebService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebService
public class EmailServiceImp implements EmailService{
    @Override
    public boolean sendEmail(String _url, String _payload) {
        return send(_url,_payload);
    }
    public boolean send(String _url,String _payload)
    {
        IClientProfile profile= DefaultProfile.getProfile("cn-hangzhou","LTAIVAIcsL4W4mMr","WTNELRL7NSestubthyEYWEOD1mqm6z");
        IAcsClient client=new DefaultAcsClient(profile);
        SingleSendMailRequest request=new SingleSendMailRequest();
        try {
            request.setAccountName("001@dm.wangzhiguan.xyz");
            request.setFromAlias("wzg");
            request.setAddressType(1);
            request.setTagName("label");
            request.setReplyToAddress(false);
            request.setToAddress(_url);
            request.setSubject("None");
            request.setHtmlBody(_payload);
            SingleSendMailResponse response=client.getAcsResponse(request);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean sendEmailBatch(String[] _url, String _payload) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(_url[0]);
        for(int i=1;i<_url.length;i++)
        {
            stringBuilder.append(","+_url[i]);
        }
        return send(stringBuilder.toString(),_payload);
    }

    @Override
    public Object validateEmailAddress(String _url) {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = clientFactory.createClient("http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx?wsdl");
        try {
            Object []result =client.invoke("ValidateEmailAddress",_url);
            System.out.println(result[0]);
            return result[0];
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        /*String _pattern="(\\d|[a-z])+@(\\d|[a-z])+.com";
        Pattern p=Pattern.compile(_pattern);
        Matcher m=p.matcher(_url);
        return m.matches();*/
    }
}
