import {IPost} from "../../../../models/post.model";
import {SeePostService} from "../../../../services/seePost.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Component, ElementRef, ViewChild} from "@angular/core";
import {CreateAnswerService} from "../../../../services/createAnswer.service";
import {IAnswer} from "../../../../models/answer.model";
import {IUser} from "../../../../models/user.model";
import {IUpvote} from "../../../../models/upvote.model";
import {IDownvote} from "../../../../models/downvote.model";

@Component({
  selector: "app-detailed-post",
  templateUrl: "./detailedPost.component.html"
})


export class DetailedPostComponent{

  @ViewChild("answerContent") answerContent! : ElementRef
  post?: IPost
  poster?: IUser
  voted: boolean = false

  constructor(private postService: SeePostService,private router: Router, private route: ActivatedRoute, private answerService : CreateAnswerService) {
  }

  hideVoteButton(){
    return !this.voted && localStorage['email'] != this.post?.author.email
  }

  upvoteAnswer(answer : IAnswer){
    console.log("test upvote")
    if (localStorage['email'] && localStorage['banned'] == false) {
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
        answer : answer
      }

      console.log("test upvote")

      this.postService.saveUpvote(upvote).subscribe( data =>
        {console.log(data), this.voted = true}
      )

    }
  }

  downvoteAnswer(answer : IAnswer){


    if (localStorage['email'] && localStorage['banned'] == false) {
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
        answer : answer
      }

      this.postService.saveDownvote(downvote).subscribe( data =>
        {console.log(data), this.voted = true}
      )
    }
  }

  ngOnInit(){
    let id : number = Number(this.route.snapshot.params['id'])


    this.postService.getPostById(id).subscribe( data =>
    {this.post = data,
      //@ts-ignore
      this.poster = this.post?.answers[0].poster
      console.log("Daca cineva incearca sa inteleaga ce se intampla aici, imi pare rau.")})
  }

  createAnswer() {
    if (localStorage['email'] && localStorage['banned'] == false) {
      let author: IUser = {
        userID: localStorage['userID'],
        email: localStorage['email'],
        score: localStorage['score'],
        moderator: localStorage['moderator'],
        banned: localStorage['banned'],
        password: localStorage['pass']
      }
      let auxAnswer: IAnswer = {
        content: this.answerContent.nativeElement.value,
        score: 0,
        //@ts-ignore
        post: this.post,
        date: new Date(),
        user: author,
      }
      console.log(auxAnswer)
      this.answerService.createAnswer(auxAnswer).subscribe(result => {
        console.log(result)
        this.router.navigate(["seePost"])
      })
    }
  }

  showButton(){
    return (localStorage['email'] == this.poster?.email || localStorage['moderator'] == true)
  }


}
