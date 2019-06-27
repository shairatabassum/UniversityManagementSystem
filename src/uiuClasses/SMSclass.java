/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.*;
import org.json.JSONObject;



/**
 *
 * @author MeRiDa
 */


public class SMSclass {
    public static void sms(String name, String number, String username, String password) throws IOException{
        
            String smsText = "Hi " + name + "," + "\n" + "Your UMS account is created." + "\n" + "Username: " + username + "\n" + "Temporary Password: " + password + "  (Please change it after login)" + "\n" + "Thanks.";
            
            final NameValuePair[] data = {
            new BasicNameValuePair("phone", number),
            new BasicNameValuePair("message", smsText),
            new BasicNameValuePair("key", "1aecd414f6c63db297e434ae17ab78114f51c32emCTPfNVBFsAXoMARNJj1Ttln1")
        };
        HttpClient httpClient = HttpClients.createMinimal();
        HttpPost httpPost = new HttpPost("https://textbelt.com/text");
        httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));
        HttpResponse httpResponse = httpClient.execute(httpPost);

        String responseString = EntityUtils.toString(httpResponse.getEntity());
        JSONObject response = new JSONObject(responseString);
        
        JOptionPane.showMessageDialog(null, "A Message was sent to " + number + ".");
    }
}
