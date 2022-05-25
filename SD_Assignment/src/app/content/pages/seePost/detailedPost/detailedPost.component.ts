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

  constructor(private postService: SeePostService,private router: Router, private route: ActivatedRoute, private answerService : CreateAnswerService) {
  }

  hideVoteButton(){
    return localStorage['email'] != this.post?.author.email
  }

  upvoteAnswer(answer : IAnswer){
    let canVote : boolean = true
    let allUpvotes: IUpvote[]
    this.postService.getUpvotes().subscribe( data => {
      allUpvotes = data
    })
    let allDownvotes: IDownvote[]
    this.postService.getDownvotes().subscribe( data => allDownvotes = data)


    // @ts-ignore
    for(let i = 0; i < allUpvotes.length; i++){
      // @ts-ignore
      if(allUpvotes[i].answer.answerID == answer.answerID && allUpvotes[i].author.email == localStorage['email']){
        canVote = false
        break
      }
    }
    // @ts-ignore
    for(let i = 0; i < allDownvotes.length && canVote; i++){
      // @ts-ignore
      if(allDownvotes[i].answer.answerID == answer.answerID && allDownvotes[i].author.email == localStorage['email']){
        canVote = false
        break
      }
    }

    if (localStorage['email'].length > 0 && localStorage['banned'] == "false" && canVote) {
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
        answer : answer
      }

      console.log("test upvote")

      this.postService.saveUpvote(upvote).subscribe( data =>
        {console.log(data)}
      )

    }
  }

  downvoteAnswer(answer : IAnswer){
    console.log("test downvote")
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
        answer : answer
      }
      console.log("test downvote2")
      this.postService.saveDownvote(downvote).subscribe( data =>
        {console.log(data)}
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
