package com;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {
    public static void main(String []args)
    {
        new UI();
    }
}
class UI
{
    EmailService emailService;
    JFrame frame;
    Box mainPanel;

    JPanel areaPanel;
    Box btnPanel;
    JButton sendBtn;
    JButton validBtn;
    JTextArea textArea;
    JLabel addressLabel;
    JLabel textLabel;
    JTextField addressText;
    public UI()
    {
        JaxWsProxyFactoryBean factoryBean=new JaxWsProxyFactoryBean();
        factoryBean.setAddress("http://localhost:7759/EmailService");
        factoryBean.setServiceClass(EmailService.class);
        emailService=(EmailService)factoryBean.create();
        initUI();
    }
    void initUI()
    {
        frame=new JFrame();
        frame.setSize(600,600);
        Box addressPanel=Box.createHorizontalBox();
        addressLabel =new JLabel("address:");
        addressPanel.add(addressLabel);
        addressText=new JTextField(8);
        addressPanel.add(addressText);
        validBtn=new JButton("valid");
        validBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address=addressText.getText()+";";
                System.out.println(address);
                String []urls=address.split(";");
                boolean flag=true;
                String error=null;
                for(int i=0;i<urls.length;i++)
                {
                    Short result=(Short)emailService.validateEmailAddress(urls[i]);
                    if(result==null || result!=1)
                    {
                        flag=false;
                        //error=urls[i];
                        if(result==null){error="The Service is not found !";break;}
                        switch (result)
                        {
                            case 0:
                            {
                                error="The address "+urls[i]+": Please re-verify";
                                break;
                            }
                            case 2:
                            {
                                error="The address "+urls[i]+ ": Just the domain name is correct";
                                break;
                            }
                            case 3:
                            {
                                error="The address "+urls[i]+ ": An unknown error";
                                break;
                            }
                            case 4:
                            {
                                error="The address "+urls[i]+ ": Mail server not found";
                                break;
                            }
                            case 5:
                            {
                                error="The address "+urls[i]+ ": Email address error";
                                break;
                            }
                            case 6:
                            {
                                error="The address "+urls[i]+ ": Free user verification exceeds quantity";
                                break;
                            }
                            case 7:
                            {
                                error="The address "+urls[i]+ " Business users cannot pass verification";
                                break;
                            }
                        }
                        break;
                    }
                }
                //boolean flag=emailService.validateEmailAddress(address);
                if (!flag){JOptionPane.showMessageDialog(frame,error,"error",JOptionPane.INFORMATION_MESSAGE);}
                else {JOptionPane.showMessageDialog(frame,"The address is valid !","information",JOptionPane.INFORMATION_MESSAGE);}
            }
        });
        addressPanel.add(validBtn);
        Box vbox=Box.createVerticalBox();
        vbox.add(addressPanel);

        textArea=new JTextArea(30,10);

        areaPanel=new JPanel(new GridLayout(1,1));
        areaPanel.add(textArea);

        btnPanel=Box.createHorizontalBox();
        sendBtn=new JButton("send");
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address=addressText.getText()+";";
                String []urls=address.split(";");
                String content=textArea.getText();
                String error=null;
               boolean flag=true;
               if(urls.length==1){flag=emailService.sendEmail(urls[0],content);}
               else {flag=emailService.sendEmailBatch(urls,content);}
                //boolean flag=emailService.sendEmail(address,content);
                if (flag){JOptionPane.showMessageDialog(frame,"The email send succeed !","information",JOptionPane.INFORMATION_MESSAGE);}
                else {JOptionPane.showMessageDialog(frame,"The email send failed !","error",JOptionPane.INFORMATION_MESSAGE);}
            }
        });
        btnPanel.add(sendBtn);
        Box vboxbtn=Box.createHorizontalBox();
        vboxbtn.add(btnPanel);

        mainPanel=Box.createVerticalBox();
        mainPanel.add(vbox);
        mainPanel.add(areaPanel);
        mainPanel.add(vboxbtn);
        Box hbox=Box.createHorizontalBox();
        hbox.add(mainPanel);
        frame.setContentPane(hbox);
        frame.setVisible(true);
    }
}