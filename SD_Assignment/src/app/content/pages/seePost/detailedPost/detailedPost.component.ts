import {IPost} from "../../../../models/post.model";
import {SeePostService} from "../../../../services/seePost.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Component, ElementRef, ViewChild} from "@angular/core";
import {CreateAnswerService} from "../../../../services/createAnswer.service";
import {IAnswer} from "../../../../models/answer.model";
import {IUser} from "../../../../models/user.model";

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
