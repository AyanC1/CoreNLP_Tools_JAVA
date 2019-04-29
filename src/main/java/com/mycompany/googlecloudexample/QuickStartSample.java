package com.mycompany.googlecloudexample;

import com.google.api.client.util.Lists;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

public class QuickStartSample {

    public static void main(String[] args) throws IOException {
        
        
        
     GoogleCredentials credential = GoogleCredentials.getApplicationDefault();   
     
        
        
    //String jsonPath = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\GoogleCloudExample\\src\\main\\java\\com\\mycompany\\googlecloudexample";
    
    //GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
                //    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
    
    // Instantiates a clientC:\Users\Admin\Documents\NetBeansProjects\GoogleCloudExample\src\main\java\com\mycompany\googlecloudexample\credential.json
    try (LanguageServiceClient language = LanguageServiceClient.create()) {

      // The text to analyze
      String text = "I loved you but you  betrayed me";
      Document doc = Document.newBuilder()
          .setContent(text).setType(Type.PLAIN_TEXT).build();

      // Detects the sentiment of the text
      Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

      System.out.printf("Text: %s%n", text);
      System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
        
    }
}
}


