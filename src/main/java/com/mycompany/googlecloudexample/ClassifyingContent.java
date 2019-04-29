package com.mycompany.googlecloudexample;

import com.google.cloud.language.v1.ClassificationCategory;
import com.google.cloud.language.v1.ClassifyTextRequest;
import com.google.cloud.language.v1.ClassifyTextResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.LanguageServiceClient;
import java.io.IOException;

public class ClassifyingContent {
    public static void main(String[] args) throws IOException {
        String text = "People can communicate with each other through different kind of expressions, but paralyzed or\n" +
"disabled people can’t express their feelings so they communicate with the external world via\n" +
"some devices, these devices could expand the abilities of a person commands.";
        // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
try (LanguageServiceClient language = LanguageServiceClient.create()) {
  // set content to the text string
  Document doc = Document.newBuilder()
      .setContent(text)
      .setType(Type.PLAIN_TEXT)
      .build();
  ClassifyTextRequest request = ClassifyTextRequest.newBuilder()
      .setDocument(doc)
      .build();
  // detect categories in the given text
  ClassifyTextResponse response = language.classifyText(request);

  for (ClassificationCategory category : response.getCategoriesList()) {
    System.out.printf("Category name : %s, Confidence : %.3f\n",
        category.getName(), category.getConfidence());
  }
}
    }
    
}
