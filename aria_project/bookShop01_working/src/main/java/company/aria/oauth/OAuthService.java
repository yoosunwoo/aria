package company.aria.oauth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class OAuthService {
	public String getKakaoAccessToken(String code) {
		String access_Token = "";
		String refresh_Token = "";
		String requireURL = "https://kauth.kakao.com/oauth/token";
		final String REST_API_KEY = "4ddb03f3af33d59aa23b0b87552eb17f";
		final String REDIRECT_URI = "http://localhost:8080/aria.com/loginOAuth";
		
		try {

			URL url = new URL(requireURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);// POST 요청을 위해 기본값이 false인 setDoOutput을 true로

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=" + REST_API_KEY);
			sb.append("&redirect_uri=" + REDIRECT_URI);
			sb.append("&code=" + code);
			System.out.println("sb : " + sb.toString());
			bw.write(sb.toString());
			bw.flush();

			int responseCode = conn.getResponseCode();
			System.out.println("\t responseCode : " + responseCode);
			//responseHeaders
			/*
			Map responseHeaders = conn.getHeaderFields();
			Iterator<Entry> entries = responseHeaders.entrySet().iterator();
	        while(entries.hasNext()) {
	        	HashMap.Entry entry = entries.next();
	        	System.out.println("response-headers : [key] : "+entry.getKey()+" [value] : "+entry.getValue());
	        }
	        */
			String line = "";
			String result = "";
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("\t response body : " + result);
				br.close();
			}catch(Exception e){
				e.printStackTrace();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"utf-8"));
				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("\t response error body : " + result);
				br.close();
			}
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_Token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			System.out.println("\n\t access_token : " + access_Token);
			System.out.println("\t refresh_token : " + refresh_Token + "\n");

			//br.close();
			bw.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	public HashMap getPropertyByAccessToken(String access_Token) throws Exception {
		String requireURL = "https://kapi.kakao.com/v2/user/me";
		HashMap properties = new HashMap();
		//HashMap properties = new HashMap(10);
		try {

			URL url = new URL(requireURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestProperty("Authorization", "Bearer "+access_Token);
			
			int responseCode = conn.getResponseCode();
			
			System.out.println("\t responseCode : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line = "";
			String result ="";
			while ((line = br.readLine()) != null) { result += line; }
			System.out.println("\t response body : " + result);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			String id = element.getAsJsonObject().get("id").getAsString();
			properties.put("id", id);
			String connected_at = element.getAsJsonObject().get("connected_at").getAsString();
			properties.put("connected_at", connected_at);
			String nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
			properties.put("nickname", nickname);
			
			Boolean has_email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
			properties.put("has_email", has_email);
			if(has_email) {
				String email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
				properties.put("email", email);
			}
			Boolean has_age_range = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_age_range").getAsBoolean();
			properties.put("has_age_range", has_age_range);
			if(has_age_range) {
				String age_range = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("age_range").getAsString();
				properties.put("age_range", age_range);
			}
			Boolean has_gender = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_gender").getAsBoolean();
			properties.put("has_gender", has_gender);
			if(has_gender) {
				String gender = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("gender").getAsString();
				properties.put("gender", gender);
			}
			
			br.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	

}
