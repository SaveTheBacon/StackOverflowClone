import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {IPost} from "../models/post.model";
import {CommonModule} from "@angular/common";
import {IUpvote} from "../models/upvote.model";
import {IDownvote} from "../models/downvote.model";

@Injectable()
export class SeePostService{

  getAllUrl = 'http://localhost:8081/posts/getAll'
  getByIdUrl = 'http://localhost:8081/posts/getPost'
  removeUrl = 'http://localhost:8081/posts/deletePost'

  addUpvoteUrl = 'http://localhost:8081/upvotes/saveUpvote'
  addDownvoteUrl = 'http://localhost:8081/downvotes/saveDownvote'

  constructor(private http: HttpClient) {
  }

  getPosts(){
    return this.http.get<IPost[]>(this.getAllUrl)
  }

  getPostById(id: number){
    let auxUrl : string = this.getByIdUrl
    auxUrl += "?id="
    auxUrl += id
    return this.http.get<IPost>(auxUrl)
  }

  saveUpvote(upvote: IUpvote){
    return this.http.post(this.addUpvoteUrl, upvote)
  }

  saveDownvote(downvote: IDownvote){
    return this.http.post(this.addDownvoteUrl, downvote)
  }

}

