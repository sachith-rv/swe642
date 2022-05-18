package com.swe642.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swe642.survey.model.surveyForm;

@Repository
public interface surveyRepository extends JpaRepository<surveyForm,Long>{

}
