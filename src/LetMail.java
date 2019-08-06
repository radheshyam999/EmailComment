package io;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LetMail")
public class LetMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public String YourEmail,YourPassword,Email,comment,subject,file;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				try {
					 response.setContentType("text/html");
					 PrintWriter out =  response.getWriter();
					
					YourEmail = (String) request.getAttribute("YourEmail");

					YourPassword = (String) request.getAttribute("YourEmailPassword");
					Email = (String) request.getAttribute("YourEmailPassword");
					subject = (String) request.getAttribute("subject");
					comment = (String) request.getAttribute("comment");
					file  =  (String) request.getAttribute("file");
			  String to = "mailtoradheshyamdubey999@gmail.com";	
		      Properties prop = new Properties();
		      prop.put("mail.smtp.host", "smtp.gmail.com");
		      prop.put("mail.smtp.socketFactory.port","465");
		      prop.put("mail.smtp.socket.Factory.class", "javax.net.ssl.SSLSocketFactory");
			  prop.put("mail.smtp.auth","true");
			  prop.put("mail.smtp.port", "465");
				
			  Session ses = Session.getDefaultInstance(prop,new MyAuth()); 
			 MimeMessage mes = new MimeMessage(ses);
			 mes.setFrom(new InternetAddress("radheshyamdubey999@gmail.com"));
			 mes.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));
			 mes.setSubject(subject);
			 Multipart body  = new MimeMultipart();
			 MimeBodyPart part1 = new MimeBodyPart();
			 part1.setText(comment);
			 MimeBodyPart part2 = new MimeBodyPart();	
			 FileDataSource fds = new FileDataSource("\'C:\\Users\\ADMIN\\Downloads\\Screenshot (6).png\'");
			 part2.setDataHandler(new DataHandler(fds));
			 part2.setFileName(fds.getName());
			 body.addBodyPart(part2);
			 mes.setContent(body);
			 Transport.send(mes);
			 out.println("<h1>Sucessfully send!</h1>");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}

		
	
	
	
	
	}


