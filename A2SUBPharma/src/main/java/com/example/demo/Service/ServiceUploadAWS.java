package com.example.demo.Service;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.Entity.Image;
import com.example.demo.Repository.ImageReposiroty;


@Service
public class ServiceUploadAWS {

	/*
	 * @Autowired private AmazonS3 amazonS3;
	 * 
	 * @Value("${aws.s3.bucket}") private String s3bucket;
	 * 
	 * @Autowired ImageReposiroty imageRepository;
	 * 
	 * public String uploadFileToS3Bucet(Image im ,MultipartFile multipartFile) {
	 * File file = convertMultipartFiletoFile(multipartFile);
	 * 
	 * String orgId = "ORG1"; String filename = "image1";
	 * 
	 * String path = orgId+"/"+filename; im.setFileName(filename); im.setPath(path);
	 * imageRepository.save(im); uploadFile(s3bucket, path, file); return "success";
	 * }
	 * 
	 * 
	 * private void uploadFile(String bucketName , String filePath, File file) {
	 * amazonS3.putObject(new PutObjectRequest(bucketName, filePath, file)
	 * .withCannedAcl(CannedAccessControlList.PublicRead) ); }
	 * 
	 * 
	 * public File convertMultipartFiletoFile(MultipartFile multipartFile) { File
	 * file = new File(multipartFile.getOriginalFilename()); try { FileOutputStream
	 * outputStream = new FileOutputStream(file);
	 * outputStream.write(multipartFile.getBytes()); } catch(final IOException e) {
	 * System.out.println("Error to convert MultipartFile to File" +
	 * e.getMessage()); }
	 * 
	 * return file; }
	 */}
