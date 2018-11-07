package com;

import javax.jws.WebService;

@WebService
public interface EmailService {
    boolean sendEmail(String _url,String _payload);
    boolean sendEmailBatch(String []_url,String _payload);
    Object validateEmailAddress(String _url);
}
