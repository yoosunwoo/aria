package company.aria.lack.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import company.aria.common.base.BaseController;
import company.aria.lack.service.LackMenuServiceImpl;
import company.aria.lack.vo.LaMenuVO;
import net.coobird.thumbnailator.Thumbnails;

@Controller("lackmenuController")
@RequestMapping(value="/lackmenu")
@EnableAsync
public class LackMenuControllerImpl extends BaseController {
	
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	@Autowired	// ARTICLE_IMAGE_REPO 여기에 이미지 저장위치가 담겨있음 저장위치 바꾸짜
	private LackMenuServiceImpl lackmenuService;
	@Autowired
	private LaMenuVO menuVO;
	
	//게시판 글 추가 하는 .do 실행 한개 이미지 글쓰기
	@RequestMapping(value="/addMenu.do" ,method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewMenu(MultipartHttpServletRequest multipartRequest, 
	HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		//multipartRequest -> 이건 파일업로드 할때 하는데 업로드를 담당하는 생성자 및 여러 메소드 포함되어있음 멀티파트리퀘스트는 짱짱맨
		// 그리고 인코딩 방식 또한 쉽게 처리됨
		// multipart 는 한 Body에서 이 2 종류의 데이터를 구분에서 넣어주는 방법 그게 multipart
		// Map 을 articleMap에 넣어놓고!!!
		Map<String,Object> articleMap = new HashMap<String, Object>();
		// Enumeration ->이건뭐지 가 아니라 멀티파트 요청에서 전달된 모든 파라미터 이름을 열거형 객체 곧(enumeration) 객체에 담아
		// 반환하는 기능을 수행할수있음 그래서 뭐 업로드된 파일의 메타데이터 처리,  폼데이터, 유효성등 파라미터의 값을 추출가능
		// 순서를 가지고 있는 배열의 한 종류 그런느낌
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){	// 데이터가 들어있는지 체크하는 기능
			String name = (String)enu.nextElement(); //jsp의 첫번째 input name인 lm_menu
			String value = multipartRequest.getParameter(name); //lm_menu의 value값을 받아옴 와일이니까 이작업을반복 jsp의 name과value를 맵에 계속저장하는과정
			articleMap.put(name,value);
		}
					// 
		String imageFileName = Menuupload(multipartRequest);	// 밑의 업로드 함수 보도록 참고 이미지 파일 네임에 넣어줌
		HttpSession session = multipartRequest.getSession();  // 멀티파트 요청한거 -> 세션에넣고
		articleMap.put("lm_id", 0);	
		articleMap.put("lm_fileName", imageFileName);	// img1 이미지 넣은걸 받아온 imageFileName 랑 해서 키 값으로
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int lm_id = lackmenuService.addNewMenu(articleMap);//이건 테이블에 새 글을 추가한 후에 그 글에대한 번호를가져온다 맞나..??
			
					//if 문은 파일을 첨부한 경우에만 수행할 수 있도록 함
			if(imageFileName!=null && imageFileName.length()!=0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO+ "\\" + "temp"+ "\\" + imageFileName);
				// 바로위의 코드 는 temp 폴더에 임시로 업로드 된 파일 객체를 생성
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+lm_id);
				FileUtils.moveFileToDirectory(srcFile, destDir,true);
				//바로위의 코드는 temp폴더의 파일을 글 번호를 이름으로 하는 폴더로 이동시킨다.
				//그리고 CURR_IMAGE_REPO_PATH의 경로 하위에 글 번호로 폴더를 생성시킴
			}
	
			message = "<script>";
			message += " alert('새 메뉴을 추가했습니다.');";
			message += " location.href='"+multipartRequest.getContextPath()+"/main/main.do'; ";
			message +=" </script>";
		    resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO+"\\"+"temp"+"\\" + imageFileName);
			srcFile.delete();
			
			message = " <script>";
			message +=" alert('추가 중 오류가 발생했습니다.');');";
			message +=" location.href='"+multipartRequest.getContextPath()+"/main/main.do'; ";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	private String Menuupload(MultipartHttpServletRequest multipartRequest) throws Exception{
		String imageFileName= null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			imageFileName=mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+"\\" + fileName);
			if(mFile.getSize()!=0){ //File Null Check
				if(!file.exists()){ //경로상에 파일이 존재하지 않을 경우
					file.getParentFile().mkdirs(); 
					//경로에 해당하는 디렉토리들을 생성
					mFile.transferTo(new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+ "\\"+imageFileName)); 
					//임시로 저장된 multipartFile을 실제 파일로 전송
				}
			}
			
		}
		return imageFileName;
	}
	
	@RequestMapping(value= "/la-menu.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(@RequestParam String lm_ls_storeName, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		session.setAttribute("lm_ls_storeName", lm_ls_storeName);
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		Map<String,List<LaMenuVO>> goodsMap=lackmenuService.listGoods(lm_ls_storeName);
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}
	
	private static String CURR_IMAGE_REPO_PATH = "C:\\board\\article_image";
	
	@RequestMapping("/thumbnails.do")
	protected void thumbnails(@RequestParam("lm_fileName") String lm_fileName,
                            	@RequestParam("lm_id") String lm_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"\\"+lm_id+"\\"+lm_fileName;
		File image=new File(filePath);
		
		if (image.exists()) { 
			Thumbnails.of(image).size(267,201).outputFormat("png").toOutputStream(out);
		}
		byte[] buffer = new byte[1024 * 8];
		out.write(buffer);
		out.close();
	}
	
	@RequestMapping(value="/la-menu-detail.do" ,method = RequestMethod.GET)
	public ModelAndView lamenuDetail(@RequestParam("lm_id") String lm_id,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName=(String)request.getAttribute("viewName");
		HttpSession session=request.getSession();
		Map goodsMap=lackmenuService.goodsDetail(lm_id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("goodsMap", goodsMap);
		return mav;
	}
}
