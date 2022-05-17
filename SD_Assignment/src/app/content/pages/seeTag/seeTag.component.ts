import {Component} from "@angular/core";
import {IPost} from "../../../models/post.model";
import {SeePostService} from "../../../services/seePost.service";
import {ITag} from "../../../models/tag.model";
import {SeeTagService} from "../../../services/seeTag.service";


@Component({
  selector: 'app-seeTag',
  templateUrl: './seeTag.component.html',
})

export class SeeTagComponent{
  tags?: ITag[]
  constructor(private seeTagService: SeeTagService) {
  }

  ngOnInit(){
    this.seeTagService.getPosts().subscribe(data =>
    {console.log(data),
      this.tags = data})
  }
}
