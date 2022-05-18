import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Students } from '../students';
import { Surveyform } from '../surveyform';
import { SurveyformService } from '../surveyform.service';

@Component({
  selector: 'app-list-all-survey',
  templateUrl: './list-all-survey.component.html',
  styleUrls: ['./list-all-survey.component.css']
})
export class ListAllSurveyComponent implements OnInit {

  //studentIds!: Students[];
  studentIds!: Surveyform[];
  constructor(private studentIdsservice: SurveyformService,private router:Router) { }

  ngOnInit(): void {
    this.getStudentIds();
  }

    private getStudentIds(){
      this.studentIdsservice.getStudentIdList().subscribe(data => {
        this.studentIds = data;
      });
    }
    

    

    surveyDetails(id: number){
      this.router.navigate(['list-all-survey/view-list-item', id]);
  }

}
