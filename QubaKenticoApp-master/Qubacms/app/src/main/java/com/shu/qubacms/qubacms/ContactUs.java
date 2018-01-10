package com.shu.qubacms.qubacms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.mail.*;
import javax.mail.internet.*;
import android.widget.EditText;
import android.view.*;
import java.util.Properties;
import android.widget.Button;
import android.os.StrictMode;

public class ContactUs extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_contact_us);

        Button sendButton = (Button) findViewById(R.id.ContactBtn);
        sendButton.setOnClickListener(this);
    }


    private void sendEmail(View view) throws AddressException, MessagingException {
        EditText eaddr = (EditText) findViewById(R.id.contactEmail);
        EditText messageText = (EditText) findViewById(R.id.contactMessage);

        //USES GMAIL SERVERS
        final String username = "keiichishiroyama@gmail.com";
        final String password = "IhateGSDP";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("keiichishiroyama@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("keiichishiroyama@gmail.com"));
            message.setSubject("KENTICO SIGN IN:  " + eaddr.getText().toString());
            message.setText(messageText.getText().toString());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        eaddr.setText("");
        messageText.setText("");
    }

    public void onClick(View view){

        if (isContactButton(view))
        {
            try {sendEmail(view);} catch (MessagingException e) {throw new RuntimeException(e);}
        }
    }

    private boolean isContactButton(View view) {
        return view == findViewById(R.id.ContactBtn);
    }

}
