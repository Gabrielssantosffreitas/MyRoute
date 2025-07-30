package com.gabriel.myroute.repository.connection.gemini;
import com.google.genai.Client;

public class ConnectionGemini {
    private static final String API_KEY = "AIzaSyAbV964qC-RA_IM8Ahop0sXzJr2JxF1z6c";

    public static Client connectionGemini(){return Client.builder().apiKey(API_KEY).build();}// cria um acesso ao gemini
}
