package com.gabriel.myroute.serviceSearch;

import java.io.IOException;

import com.gabriel.myroute.entity.Roteiro;
import com.gabriel.myroute.repository.connection.gemini.ConnectionGemini;
import com.gabriel.myroute.repository.roteiro.RoteiroRepository;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceSearch {
	
	
	private String geminaiSearch(String cidade,String texto,String clima) {
		
		Client cliente = ConnectionGemini.connectionGemini();

		GenerateContentResponse response = cliente.models.generateContent("gemini-2.5-flash",
				"Voce e um especialista em turismo entao crie um Roteiro de turismo basiado nas preferencias do usuario que vão estar entre <preferencia></preferencia> não quero nada alem do texto  nao quero [*] n texto tem que ter os principais atraçoes e tem que ser de acordo com o clima basseado na tag por umtimo quero no maximo 300 linhas <clima></clima> e na tag cidade <cidade></cidade> dito isso aqui esta as informaçoes <preferencia>"+ texto+ "</preferencia> <clima> "+clima+"</clima> <cidade>"+cidade +"</cidade> se clima for igual a 'essa cidade nao existe' retorne somante false' ", null);
		
		return response.text();
		
	}
	
	private  String getApiResponse(String cidade) {
		
		String url = " https://api.openweathermap.org/data/2.5/weather?q="+cidade+"&appid=2df8a027e8ee2bc12a68e6d4069ade63&units=metric ";
		
		OkHttpClient client = new OkHttpClient();
		
        okhttp3.Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
          } catch (IOException e) {
			e.printStackTrace();
			return "essa cidade nao existe";
		}
		
	}

	public void pesquisar(String cidade, String nome, String texto,long id) {
		Roteiro plan = new Roteiro();
		
		String clima = getApiResponse(cidade);
		String roteiro = geminaiSearch(cidade, texto,clima);
		
		RoteiroRepository rr = new RoteiroRepository();
		
		plan.setNome(nome);
		plan.setRoteiro(roteiro);
		plan.setId_user(id);
	
		
		rr.setRoteiro(plan);
	}
}
