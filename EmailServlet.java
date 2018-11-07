package MyServlet;

import com.EmailService;
import com.EmailServiceImpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailService emailService=new EmailServiceImpService().getEmailServiceImpPort();
        try
        {
            String btn=request.getParameter("Email");
            System.out.println(btn);
            if(btn.equals("验证邮箱地址"))
            {
                String address=request.getParameter("address")+";";
                String []urls=address.split(";");
                boolean flag=true;
                String error=null;
                for(int i=0;i<urls.length;i++)
                {

                    Object res=emailService.validateEmailAddress(urls[i]);
                    Short result=(Short)res;
                    System.out.println(result);
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
                if(flag) {
                    String res="The address is valid !";
                    request.setAttribute("result", res);
                    request.getRequestDispatcher("Email.jsp").forward(request,response);
                }
                else {
                    request.setAttribute("result", error);
                    request.getRequestDispatcher("Email.jsp").forward(request, response);
                }
            }
            else if(btn.equals("发送邮件"))
            {
                String message=request.getParameter("message");
                String address=request.getParameter("address")+";";
                String []urls=address.split(";");
                List<String> list=new ArrayList<String>();
                for(int i=0;i<urls.length;i++)list.add(urls[i]);
                boolean flag=true;
                if(urls.length==1){flag=emailService.sendEmail(urls[0],message);}
                else {flag=emailService.sendEmailBatch(list,message);}
                String info=null;
                if(flag)info="send succeed !";
                else info="send failed !";
                request.setAttribute("result",info);
                request.getRequestDispatcher("Email.jsp").forward(request, response);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
