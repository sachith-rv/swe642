package com.swe642.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swe642.survey.exception.ResourceNotFoundException;
import com.swe642.survey.model.surveyForm;
import com.swe642.survey.repository.surveyRepository;





@CrossOrigin(origins = "http://localhost:50096")
@RestController
@RequestMapping("/api/v1/")
public class surveyFormController {
	
	@Autowired
	private surveyRepository surveyRepository;
	

	// get all surveys
	@GetMapping("/swe642surveys")
	public List<surveyForm> getAllSurveys(){
		return surveyRepository.findAll();
	}	
	
	// insert survey details rest API
		@PostMapping("/swe642surveys")
		public surveyForm createSurveyForm(@RequestBody surveyForm survey) {
			return surveyRepository.save(survey);
		}
		
		// get survey details by id rest API
		@GetMapping("/swe642surveys/{id}")
		public ResponseEntity<surveyForm> getSurveyDetailsById(@PathVariable Long id) {
			surveyForm survey = surveyRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Survey not exist with id :" + id));
			return ResponseEntity.ok(survey);
		}
}
