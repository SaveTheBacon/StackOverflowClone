import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {IPost} from "../models/post.model";
import {CommonModule} from "@angular/common";

@Injectable()
export class SeePostService{

  getAllUrl = 'http://localhost:8081/posts/getAll'

  constructor(private http: HttpClient) {
  }

  getPosts(){
    return this.http.get<IPost[]>(this.getAllUrl)
  }

}
