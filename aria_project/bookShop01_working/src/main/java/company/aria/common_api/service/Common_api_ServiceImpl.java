package company.aria.common_api.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import company.aria.common_api.dao.Common_api_DAO;
import company.aria.common_api.vo.Common_api_VO;

@Service("Common_api_Service")
@Transactional(propagation=Propagation.REQUIRED)
//@EnableAsync
public class Common_api_ServiceImpl implements Common_api_Service{
	@Autowired
	private Common_api_DAO common_api_dao;
	@Autowired
	private Common_api_VO common_api_vo;
	
	@Override
	public List<Common_api_VO> getCommonApi(int pageNum,String searchCtprvnNm,int numOfRows)throws Exception{
		String pageNumber = pageNum+"";// == Integer.parseInt(pageNumber);
		String numberOfRows = numOfRows+"";
		List<Common_api_VO> common_api_list = new ArrayList();
		try {
			StringBuilder urlBuilder = new StringBuilder("http://api.data.go.kr/openapi/tn_pubr_public_chil_wlfare_mlsv_api"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "qSz%2FhoZLlYtMPaV6JpbDPiMv8BMQNW42fy8r0jMGkXqBF0S9STzgRR7WRb7FGmHExCQiH9sm96%2Bjn9L5eBQUZw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNumber, "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numberOfRows, "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*XML/JSON 여부*/
	        
	        //urlBuilder.append("&" + URLEncoder.encode("mrhstNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*가맹점명*/
	        //urlBuilder.append("&" + URLEncoder.encode("mrhstCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*가맹점유형코드*/
	        urlBuilder.append("&" + URLEncoder.encode("ctprvnNm","UTF-8") + "=" + URLEncoder.encode(searchCtprvnNm, "UTF-8")); /*시도명*/
	        //urlBuilder.append("&" + URLEncoder.encode("signguNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구명*/
	        //urlBuilder.append("&" + URLEncoder.encode("signguCode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시군구코드*/
	        //urlBuilder.append("&" + URLEncoder.encode("rdnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지도로명주소*/
	        //urlBuilder.append("&" + URLEncoder.encode("lnmadr","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소재지지번주소*/
	        //urlBuilder.append("&" + URLEncoder.encode("latitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*위도*/
	        //urlBuilder.append("&" + URLEncoder.encode("longitude","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*경도*/
	        //urlBuilder.append("&" + URLEncoder.encode("phoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*전화번호*/
	        //urlBuilder.append("&" + URLEncoder.encode("weekdayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*평일운영시작시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("weekdayOperColseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*평일운영종료시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("satOperOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*토요일운영시작시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("satOperCloseHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*토요일운영종료시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("holidayOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공휴일운영시작시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("holidayCloseOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*공휴일운영종료시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("dlvrOperOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*배달시작시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("dlvrCloseOpenHhmm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*배달종료시각*/
	        //urlBuilder.append("&" + URLEncoder.encode("institutionNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관명*/
	        //urlBuilder.append("&" + URLEncoder.encode("institutionPhoneNumber","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관리기관전화번호*/
	        //urlBuilder.append("&" + URLEncoder.encode("referenceDate","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*데이터기준일자*/
	        //urlBuilder.append("&" + URLEncoder.encode("instt_code","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*제공기관코드*/
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(),"utf-8"));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        
	        System.out.println("\t response body : " + sb);
	        
	        JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(sb.toString());
			element = element.getAsJsonObject().get("response").getAsJsonObject().get("body").getAsJsonObject().get("items");
			//element = element.getAsJsonArray().get(0);
			
			Iterator<JsonElement> iterator = element.getAsJsonArray().iterator();
			while(iterator.hasNext()) {
				JsonElement entry = iterator.next();
				////Spring Error - auto dependency injection
				////To resolve this problem -> Create new VO
				Common_api_VO common_api_vo = new Common_api_VO();
				String mrhstNm = entry.getAsJsonObject().get("mrhstNm").getAsString();
				common_api_vo.setMrhstNm(mrhstNm);
				String ctprvnNm = entry.getAsJsonObject().get("ctprvnNm").getAsString();
				common_api_vo.setCtprvnNm(ctprvnNm);
				String signguNm = entry.getAsJsonObject().get("signguNm").getAsString();
				common_api_vo.setSignguNm(signguNm);
				String rdnmadr = entry.getAsJsonObject().get("rdnmadr").getAsString();
				common_api_vo.setRdnmadr(rdnmadr);
				String lnmadr = entry.getAsJsonObject().get("lnmadr").getAsString();
				common_api_vo.setLnmadr(lnmadr);
				String latitude = entry.getAsJsonObject().get("latitude").getAsString();
				common_api_vo.setLatitude(latitude);
				String longitude = entry.getAsJsonObject().get("longitude").getAsString();
				common_api_vo.setLongitude(longitude);
				String phoneNumber = entry.getAsJsonObject().get("phoneNumber").getAsString();
				common_api_vo.setPhoneNumber(phoneNumber);
				String referenceDate = entry.getAsJsonObject().get("referenceDate").getAsString();
				common_api_vo.setReferenceDate(referenceDate);
				
				common_api_list.add(common_api_vo);
			}
	        rd.close();
	        conn.disconnect();
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\t common_api_list.size : "+common_api_list.size());	
		return common_api_list;
	}
//	@Override
//	public List<Common_api_VO> selectLackStoreList()throws Exception{
//		List<Common_api_VO> lackStoreList = common_api_dao.selectLackStoreList();
//		return lackStoreList;
//	}
//	@Override
//	public int insertNewLackStore(Common_api_VO common_api_VO)throws Exception{
//		int result = common_api_dao.insertNewLackStore(common_api_VO);
//		return result;
//	}
	
	@Async
	@Override
	public Future<Integer> searchAllStore(String searchCtprvnNm)throws Exception{
		int result = 1;
		int numOfRows = 100;
		try {
			int pageNum=1;
		while(pageNum<3) {
			List<Common_api_VO> searchList = getCommonApi(pageNum,searchCtprvnNm,numOfRows);
			common_api_dao.searchAllStore(searchList);
//			CommonTask task = new CommonTask(searchList); 
//			CompletableFuture.runAsync(task);
			if(searchList.size()!=100) break;
			pageNum++;
		}
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
			return new AsyncResult<Integer>(result);
		}
		return new AsyncResult<Integer>(result);
	}
	
//	@Async
//	@Override
//	public CompletableFuture<Integer> searchAllStore(String searchCtprvnNm)throws Exception{
//		int result = 1;
//		int numOfRows = 100;
//		try {
//			int pageNum=1;
//		while(pageNum<3) {
//			List<Common_api_VO> searchList = getCommonApi(pageNum,searchCtprvnNm,numOfRows);
//			common_api_dao.searchAllStore(searchList);
////			CommonTask task = new CommonTask(searchList); 
////			CompletableFuture.runAsync(task);
//			if(searchList.size()!=100) break;
//			pageNum++;
//		}
//		}catch(Exception e) {
//			e.printStackTrace();
//			result = 0;
//			return CompletableFuture.completedFuture(result);
//		}
//		return CompletableFuture.completedFuture(result);
//	}
//		@Override
//		public void searchAllStore(String searchCtprvnNm)throws Exception{
//			//int result = 1;
//			int numOfRows = 100;
//			try {
//				int pageNum=1;
//			//prevent too many data
//			while(true) {
//				List<Common_api_VO> searchList = getCommonApi(pageNum,searchCtprvnNm,numOfRows);
//				common_api_dao.searchAllStore(searchList);
//				if(searchList.size()!=100) break;
//				pageNum++;
//			}
//			}catch(Exception e) {
//				e.printStackTrace();
//				//result = 0;
//			}
//			//return result;
//		}

}
