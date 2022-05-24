import {Injectable} from "@angular/core";
import {IPost} from "../models/post.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";


@Injectable()
export class CreatePostService{

  createPostURL = 'http://localhost:8081/posts/savePost'

  constructor(private http: HttpClient) {
  }

  createPost(post : IPost){
    console.log("post ajung in service")
    console.log(post)
    return this.http.post(this.createPostURL, post)
  }
}
