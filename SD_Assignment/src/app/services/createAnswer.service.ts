import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IAnswer} from "../models/answer.model";


@Injectable()
export class CreateAnswerService{

  createAnswerURL = 'http://localhost:8081/answers/saveAnswer'

  constructor(private http: HttpClient) {
  }

  createAnswer(answer : IAnswer){
    console.log(answer)
    return this.http.post(this.createAnswerURL, answer)
  }
}
