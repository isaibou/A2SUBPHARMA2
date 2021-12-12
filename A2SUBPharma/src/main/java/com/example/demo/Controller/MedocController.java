package com.example.demo.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.example.demo.Entity.Image;
import com.example.demo.Entity.Medoc;
import com.example.demo.Entity.Meme;
import com.example.demo.Repository.ImageReposiroty;
import com.example.demo.Repository.MedocRepository;
import com.example.demo.Repository.MemeRepo;
import com.example.demo.Service.ServiceUploadAWS;

@Controller
public class MedocController {

	private String mdpImport ="import";
	private final String file_name = "C:\\Users\\Public\\Documents\\ListMedocs.xltx";
	@Autowired
	MedocRepository medocReposiroty;
	@Autowired
	MemeRepo memeRepository;
	@Autowired
	ServiceUploadAWS uploads3;
	@Autowired
	ImageReposiroty imageRepository;
	
	/*
	 * @Autowired private AmazonS3 amazonS3;
	 */
	
	
	@RequestMapping(value="/LoginVrai")
	public String Login() {
		return "LoginVrai";
	}
	

	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Meme> allMedoc = memeRepository.findAll();
		model.addAttribute("medoc", allMedoc);
		return "index1";
	}
	
	@RequestMapping("/medoc")
	public String medoc(Model model){
		
		List<Meme> allMedoc = memeRepository.findAll();
		model.addAttribute("medoc", allMedoc);
		
		return "medoc";
	}
	
	@RequestMapping(value="/import")
	public String importer() {
		return "import";
	}
	
	
	@RequestMapping("/recherchePrincip")
	public String recherchePrincip(Model model, @RequestParam(name ="princip") String princip){
		
		List<Meme> allMedoc = memeRepository.findByPrincipContainingIgnoringCase(princip);
		model.addAttribute("medoc", allMedoc);
		model.addAttribute("princip", princip);
		
		return "index1";
	}
	
	@RequestMapping("/rechercher")
	public String recherche(Model model, @RequestParam(name = "nom") String nom){
		
		List<Meme> allMedoc = memeRepository.chercherMEdoc(nom);
		List<Meme> allMeme = memeRepository.findByNomContainingIgnoringCase(nom);
		List<Meme> memeAll = new ArrayList<Meme>();
		for (Meme meme : allMeme) {
		  memeAll = 	memeRepository.findByPrincip( meme.getPrincip());
		  System.err.println(meme.getPrincip());
		 System.out.println(memeAll.toString());
		}
		System.err.println(memeAll.toString());
		
		model.addAttribute("medoc", memeAll);
	//	model.addAttribute("medoc", allMedoc);
		model.addAttribute("nom", nom);
		
		return "index1";
	}
	
	
	
	
	@RequestMapping("/getData")
	public String  loadData( @RequestParam("ExcelFile") MultipartFile ExcelFile) throws IOException {
		
		List<Meme> memes =  new ArrayList<Meme>();
		
		
			
		
     //   FileInputStream excelFile = new FileInputStream(new File(file_name));
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile.getInputStream());

      //  XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        
        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
            Meme meme = new Meme();
                
            XSSFRow row = worksheet.getRow(i);
            meme.setCIP((long) row.getCell(0).getNumericCellValue());
            meme.setNom(row.getCell(1).getStringCellValue());
            meme.setCode(row.getCell(2).getStringCellValue());
            meme.setPrincip(row.getCell(3).getStringCellValue());
            meme.setPrix((long) row.getCell(4).getNumericCellValue());

            memes.add(meme);
        }
        
       
     
        memeRepository.saveAll(memes);
        System.out.println("omkl");
                			return "redirect:/index";


		}
	
	
	@RequestMapping(value="/data")
	public String importerImage(@RequestParam("password")String pass, Model model) {
		if(pass.equals(mdpImport)) {
			return "import";
		}
		else {
			model.addAttribute("errors", "Mot de passe incorect");
			return"Login2";
		}
	}
	

	@RequestMapping(value="/Login2")
	public String Login2 () {
		return "Login2";
	}
	
	/*
	 * @RequestMapping(value="/saveImage1") public String
	 * saveImage(@RequestParam("image") MultipartFile image) throws IOException {
	 * Image im = new Image(); im.setId((long) 1); imageRepository.save(im);
	 * uploads3.uploadFileToS3Bucet(im, image); return "medoc"; }
	 */
		
	}
		
		











