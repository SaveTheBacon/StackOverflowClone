import {Component, Input} from "@angular/core";
import {IPost} from "../../../../models/post.model";
import {ITag} from "../../../../models/tag.model";


@Component({
  selector: "app-individual-post",
  templateUrl: "./individualPost.component.html"
})

export class IndividualPostComponent{
  @Input() post?: IPost
  tag?: ITag
}
