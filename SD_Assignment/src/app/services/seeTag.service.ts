import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ITag} from "../models/tag.model";
import {IPost} from "../models/post.model";


@Injectable()
export class SeeTagService{

  getAllUrl = 'http://localhost:8081/tags/getAll'

  constructor(private http: HttpClient) {
  }

  getPosts(){
    return this.http.get<ITag[]>(this.getAllUrl)
  }

}
