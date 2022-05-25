import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {IPost} from "../models/post.model";
import {CommonModule} from "@angular/common";
import {IUpvote} from "../models/upvote.model";
import {IDownvote} from "../models/downvote.model";
import {IAnswer} from "../models/answer.model";

@Injectable()
export class SeePostService{

  getAllUrl = 'http://localhost:8081/posts/getAll'
  getByIdUrl = 'http://localhost:8081/posts/getPost'
  deletePostUrl = 'http://localhost:8081/posts/deletePost'
  deleteAnswerUrl = 'http://localhost:8081/answers/deleteAnswer'

  addUpvoteUrl = 'http://localhost:8081/upvotes/saveUpvote'
  addDownvoteUrl = 'http://localhost:8081/downvotes/saveDownvote'

  updatePostUrl = 'http://localhost:8081/posts/updatePost'
  updateAnswerUrl = 'http://localhost:8081/answers/updateAnswer'

  getUpvoteUrl = 'http://localhost:8081/upvotes/getAll'
  getDownvoteUrl = 'http://localhost:8081/downvotes/getAll'

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
    if(upvote.post != null){
      this.updatePost(upvote.post, 1, upvote)
    }
    else{
      // @ts-ignore
      this.updateAnswer(upvote.answer, 1, upvote)
    }
    return this.http.post(this.addUpvoteUrl, upvote)
  }

  saveDownvote(downvote: IDownvote){
    if(downvote.post != null){
      this.updatePost(downvote.post, -1, undefined, downvote)
    }
    else{
      // @ts-ignore
      this.updateAnswer(downvote.answer, -1, undefined, downvote)
    }
    return this.http.post(this.addDownvoteUrl, downvote)
  }

  updatePost(post : IPost, scoreModifier : number, upvote? : IUpvote, downvote? : IDownvote){
    let newPost : IPost ={
      postID :post.postID,
      title : post.title,
      content : post.content,
      score : post.score + scoreModifier,
      creationDate : post.creationDate,
      author : post.author,
      upvotes : post.upvotes,
      downvotes: post.downvotes,
      tags: post.tags,
      answers: post.answers
    }
    if (scoreModifier == 1){

      if(!newPost.upvotes){
        newPost.upvotes = []
      }

      // @ts-ignore
      newPost.upvotes.push(upvote)
    }
    else{
      if(!newPost.downvotes){
        newPost.downvotes = []
      }

      // @ts-ignore
      newPost.downvotes.push(downvote)
    }

    return this.http.put(this.updatePostUrl, newPost)
  }

  updateAnswer(answer : IAnswer, scoreModifier: number, upvote? : IUpvote, downvote? : IDownvote){
    let newAnswer : IAnswer= {
      score : answer.score + scoreModifier,
      content : answer.content,
      answerID : answer.answerID,
      //@ts-ignore
      user: answer.poster,
      post: answer.post,
      upvotes: answer.upvotes,
      downvote: answer.downvote,
      date: answer.date

    }
    if (scoreModifier == 1){
      if(!newAnswer.upvotes){
        newAnswer.upvotes = []
      }
      // @ts-ignore
      newAnswer.upvotes.push(upvote)
    }
    else{
      if(!newAnswer.downvote){
        newAnswer.downvote = []
      }
      // @ts-ignore
      newAnswer.downvote.push(downvote)
    }
    console.log(answer)
    console.log(newAnswer)
    console.log("FIX INAINTE DE RETURN")
    return this.http.put(this.updateAnswerUrl, newAnswer)

  }

  removePost(post : IPost){

    let id = post.postID
    if (id != undefined){
      let params = new HttpParams().set('id', id)
      return this.http.delete(this.deletePostUrl, {params: params, responseType : "text"})
    }
    return 0

  }

  getUpvotes(){
    return this.http.get<IUpvote[]>(this.getUpvoteUrl)
  }

  getDownvotes(){
    return this.http.get<IDownvote[]>(this.getDownvoteUrl)
  }

}

