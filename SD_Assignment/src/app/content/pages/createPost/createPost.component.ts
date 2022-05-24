import {Component, ElementRef, ViewChild} from "@angular/core";
import {ITag} from "../../../models/tag.model";
import {IPost} from "../../../models/post.model";
import {CreatePostService} from "../../../services/createPost.service";
import {IUser} from "../../../models/user.model";
import {Router} from "@angular/router";


@Component({
  selector: 'app-createPost',
  templateUrl: './createPost.component.html',
})

export class CreatePostComponent {
  tag: string = ''
  newTags: ITag[] = []

  @ViewChild("title") title! : ElementRef
  @ViewChild("content") content! : ElementRef

  constructor(private createPostService : CreatePostService, private router: Router) {
  }

  addTag(){
    if (this.tag != '' && !this.newTags.find(it => it.name == this.tag)){
      this.newTags?.push({name: this.tag})
      this.tag = ''
    }
  }

  submitPost(){
    if(localStorage['email']) {
      let author: IUser = {
        userID: localStorage['userID'],
        email: localStorage['email'],
        score: localStorage['score'],
        moderator: localStorage['moderator'],
        banned: localStorage['banned'],
        password: localStorage['pass']
      }
      let post: IPost = {
        tags: this.newTags,
        title: this.title.nativeElement.value,
        creationDate: new Date(),
        score: 0,
        answers: [],
        content: this.content.nativeElement.value,
        poster: author,
        upvotes: [],
        downvotes: []
      }
      this.createPostService.createPost(post).subscribe(result => {
        console.log(result)
        this.router.navigate(["seePost"])
      })
    }
  }
}
