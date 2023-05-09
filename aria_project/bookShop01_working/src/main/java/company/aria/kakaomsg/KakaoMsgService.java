package company.aria.kakaomsg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class KakaoMsgService {
	public void sendMsgByAccessToken(HashMap accessMap)throws Exception{
		String requireURL = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
		
		try {
			URL url = new URL(requireURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Authorization", "Bearer "+accessMap.get("access_Token"));
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
						StringBuilder sb = new StringBuilder();
						sb.append("template_object={");
						sb.append("\"object_type\": \"text\",");
						sb.append("\"text\": \""+accessMap.get("sendMsg")+"\",");
						sb.append("\"link\": {\"web_url\": \"http://localhost:8080/aria.com/main/main.do\", \"mobile_web_url\": \"http://localhost:8080/aria.com/main/main.do\"},");
						sb.append("\"button_title\": \"사이트 바로가기\"}");
						System.out.println("sb : " + sb.toString());
						bw.write(sb.toString());
						bw.flush();
			
			
			int responseCode = conn.getResponseCode();
			System.out.println("\t responseCode : " + responseCode);
			
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
			//br.close();
			bw.close();
			conn.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void sendMsgFriendsByAccessToken(HashMap accessMap)throws Exception{
		String requireURL = "https://kapi.kakao.com/v1/api/talk/friends/message/default/send";
		
		try {
			URL url = new URL(requireURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Authorization", "Bearer "+accessMap.get("access_Token"));
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
						StringBuilder sb = new StringBuilder();
						sb.append("receiver_uuids=["+"\""+accessMap.get("sendUuid")+"\"]");
						sb.append("&");
						sb.append("template_object={");
						sb.append("\"object_type\": \"text\",");
						sb.append("\"text\": \""+accessMap.get("sendMsg")+"\",");
						sb.append("\"link\": {\"web_url\": \"http://localhost:8080/aria.com/main/main.do\", \"mobile_web_url\": \"http://localhost:8080/aria.com/main/main.do\"},");
						sb.append("\"button_title\": \"사이트 바로가기\"}");
						System.out.println("sb : " + sb.toString());
						bw.write(sb.toString());
						bw.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println("\t responseCode : " + responseCode);
			
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
			//br.close();
			bw.close();
			conn.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public List callKakaoFriends(String access_Token)throws Exception{
		String requireURL = "https://kapi.kakao.com/v1/api/talk/friends";
		List<HashMap> friendsList = new ArrayList<HashMap>();
		
		//example
		requireURL+="?order=asc&limit=10";
		//
		
		try {
			URL url = new URL(requireURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(false);// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			//conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Authorization", "Bearer "+access_Token);
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
						//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
						//StringBuilder sb = new StringBuilder();
//						sb.append("\"limit=10\"");
//						sb.append("\"object_type\": \"text\",");
//						sb.append("\"text\": \""+accessMap.get("sendMsg")+"\",");
//						sb.append("\"link\": {\"web_url\": \"http://localhost:8080/aria.com/main/main.do\", \"mobile_web_url\": \"http://localhost:8080/aria.com/main/main.do\"},");
//						sb.append("\"button_title\": \"사이트 바로가기\"}");
//						System.out.println("sb : " + sb.toString());
						//bw.write(sb.toString());
						//bw.flush();
			////
			conn.connect();
			////
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
				
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);
				
				JsonArray elements = element.getAsJsonObject().get("elements").getAsJsonArray();
				
				for(int i=0;i<elements.size();i++) {
					HashMap friend = new HashMap();
					String id = elements.get(i).getAsJsonObject().get("id").getAsString();
					friend.put("id", id);
					String nickname = elements.get(i).getAsJsonObject().get("profile_nickname").getAsString();
					friend.put("nickname", nickname);
					String uuid = elements.get(i).getAsJsonObject().get("uuid").getAsString();
					friend.put("uuid", uuid);
					Boolean allowed_msg = elements.get(i).getAsJsonObject().get("allowed_msg").getAsBoolean();
					friend.put("allowed_msg", allowed_msg);
					friendsList.add(friend);
				}
				
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
			//br.close();
			//bw.close();
			conn.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return friendsList;

		}
	}

}

