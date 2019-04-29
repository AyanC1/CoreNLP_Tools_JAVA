package com.mycompany.googlecloudexample;

import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Token;
import java.io.IOException;

public class SyntaxAnalysis {
    public static void main(String[] args) throws IOException {
        
        String text = "Hi there, i have found this code with a lot of effort an dhardwork. please do value it";
        // Instantiate the Language client com.google.cloud.language.v1.LanguageServiceClient
try (LanguageServiceClient language = LanguageServiceClient.create()) {
  Document doc = Document.newBuilder()
      .setContent(text)
      .setType(Type.PLAIN_TEXT)
      .build();
  AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
      .setDocument(doc)
      .setEncodingType(EncodingType.UTF16)
      .build();
  // analyze the syntax in the given text
  AnalyzeSyntaxResponse response = language.analyzeSyntax(request);
  // print the response
  for (Token token : response.getTokensList()) {
    System.out.printf("\tText: %s\n", token.getText().getContent());
    System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
    System.out.printf("Lemma: %s\n", token.getLemma());
    System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
    System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
    System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
    System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
    System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
    System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
    System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
    System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
    System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
    System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
    System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
    System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
    System.out.println("DependencyEdge");
    System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
    System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
  }
 
}
    }
    
}
