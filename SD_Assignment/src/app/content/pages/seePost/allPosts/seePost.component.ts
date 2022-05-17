import {Component} from "@angular/core";
import {SeePostService} from "../../../../services/seePost.service";
import {IPost} from "../../../../models/post.model";


@Component({
  selector: 'app-seeQuestion',
  templateUrl: './seePost.component.html',
})

export class SeePostComponent {
  posts?: IPost[]
  constructor(private seePostService: SeePostService) {
  }

  ngOnInit(){
    this.seePostService.getPosts().subscribe(data =>
    {console.log(data),
      this.posts = data})
  }
}
