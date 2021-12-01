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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Medoc;
import com.example.demo.Entity.Meme;
import com.example.demo.Repository.MedocRepository;
import com.example.demo.Repository.MemeRepo;

@Controller
public class MedocController {

	private final String file_name = "C:\\Users\\Public\\Documents\\ListMedocs.xltx";
	@Autowired
	MedocRepository medocReposiroty;
	@Autowired
	MemeRepo memeRepository;
	
	@GetMapping("/medoc")
	public String medoc(Model model){
		
		List<Meme> allMedoc = memeRepository.findAll();
		model.addAttribute("medoc", allMedoc);
		
		return "medoc";
	}
	
	@GetMapping("/rechercher")
	public String recherche(Model model, @RequestParam(name = "nom") String nom){
		
		List<Meme> allMedoc = memeRepository.chercherMEdoc(nom);
		List<Meme> allMeme = memeRepository.findByNomContaining(nom);
		List<Meme> memeAll = new ArrayList<Meme>();
		for (Meme meme : allMeme) {
		  memeAll = 	memeRepository.findByPrincip( meme.getPrincip());
		  System.err.println(meme.getPrincip());
		 System.out.println(memeAll.toString());
		}
		System.err.println(memeAll.toString());
		
		model.addAttribute("medoc", memeAll);
	//	model.addAttribute("medoc", allMedoc);
		
		return "medoc";
	}
	
	@GetMapping("/getData")
	public String  loadData() throws IOException {
		
		List<Meme> memes =  new ArrayList<Meme>();
		
		
			
		
        FileInputStream excelFile = new FileInputStream(new File(file_name));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
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
                			return "";


		}
		
	}
		
		











