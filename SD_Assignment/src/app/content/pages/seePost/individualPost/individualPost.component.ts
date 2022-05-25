import {Component, Input} from "@angular/core";
import {IPost} from "../../../../models/post.model";
import {ITag} from "../../../../models/tag.model";
import {SeePostService} from "../../../../services/seePost.service";
import {IUpvote} from "../../../../models/upvote.model";
import {IUser} from "../../../../models/user.model";
import {IDownvote} from "../../../../models/downvote.model";
import {Router} from "@angular/router";


@Component({
  selector: "app-individual-post",
  templateUrl: "./individualPost.component.html"
})

export class IndividualPostComponent{
  @Input() post?: IPost
  tag?: ITag

  constructor(private postService: SeePostService, private router : Router) {
  }

  redirect(){
    this.router.navigate(["seePost/" + this.post?.postID])
  }

  showButton(){
    return localStorage['moderator'] == "true"
  }

  hideVoteButton(){
    return localStorage['email'] == this.post?.author.email
  }

  removePost(post?: IPost){
    if (post != undefined)
      this.postService.removePost(post)
  }

  upvotePost(){
    console.log("test upvote")
    if (localStorage['email'].length > 0 && localStorage['banned'] == "false") {
      console.log("test upvote2")
      let author: IUser = {
        userID: localStorage['userID'],
        email: localStorage['email'],
        score: localStorage['score'],
        moderator: localStorage['moderator'],
        banned: localStorage['banned'],
        password: localStorage['pass']
      }

      let upvote : IUpvote = {
        author : author,
        post : this.post
      }

      console.log("test upvote")
      console.log(upvote)
      this.postService.saveUpvote(upvote).subscribe( data =>
      {console.log(data)}
      )

    }
  }

  downvotePost(){


    if (localStorage['email'].length > 0 && localStorage['banned'] == "false") {
      let author: IUser = {
        userID: localStorage['userID'],
        email: localStorage['email'],
        score: localStorage['score'],
        moderator: localStorage['moderator'],
        banned: localStorage['banned'],
        password: localStorage['pass']
      }

      let downvote : IDownvote = {
        author : author,
        post : this.post
      }

      this.postService.saveDownvote(downvote).subscribe( data =>
        {console.log(data)}
      )
    }
  }
}
