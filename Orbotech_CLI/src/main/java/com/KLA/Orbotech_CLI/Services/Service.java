package com.KLA.Orbotech_CLI.Services;

import com.KLA.Orbotech_CLI.Entity.AuthUser;
import com.KLA.Orbotech_CLI.Entity.User;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import static com.KLA.Orbotech_CLI.OrbotechCliApplication.isLogin;
import static com.KLA.Orbotech_CLI.OrbotechCliApplication.isNewUser;

public class Service {

    public void SignUp(User newUser) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String signupEndpoint = "http://localhost:9090/signup";

            String signupData = String.format("{\"name\": \"%s\", \"email\": \"%s\",\"password\": \"%s\",\"userType\": \"%s\"}",
                    newUser.getName(),
                    newUser.getEmail(),
                    newUser.getPassword(),
                    newUser.getUserType()
            );

            HttpPost postRequest = new HttpPost(signupEndpoint);
            postRequest.setEntity(new StringEntity(signupData, ContentType.APPLICATION_JSON));

            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                // Handle the response
                int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);

                if (statusCode == 200) {
                    if(responseBody.contains("OK")){
                        // Login successful
                        System.out.println("SignUp successful!");
                        isNewUser = true;
                    }
                    else if(responseBody.contains("NOT_FOUND")){
                        // Login failed
                        System.out.println("SignUp failed!");
                    }
                } else {
                    // SERVER DOWN
                    System.out.println("SOMETHING WRONG ON SIGNUP");
                    // Display error message or provide the user another chance to enter valid credentials
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Login(AuthUser user) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String loginEndpoint = "http://localhost:9090/login";

            String loginData = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", user.getEmail(), user.getPassword());

            HttpPost postRequest = new HttpPost(loginEndpoint);
            postRequest.setEntity(new StringEntity(loginData, ContentType.APPLICATION_JSON));

            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                // Handle the response
                int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);

                if (statusCode == 200) {
                    if(responseBody.contains("OK")){
                        // Login successful
                        System.out.println("Login successful!");
                        isLogin = true;
                    }
                    else if(responseBody.contains("NOT_FOUND")){
                        // Login failed
                        System.out.println("Login failed!");
                    }
                } else {
                    // SERVER DOWN
                    System.out.println("SOMETHING WRONG ON LOGIN");
                    // Display error message or provide the user another chance to enter valid credentials
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
