import {Component, Input} from "@angular/core";
import {IPost} from "../../../../models/post.model";


@Component({
  selector: "app-individual-post",
  templateUrl: "./individualPost.component.html"
})

export class IndividualPostComponent{
  @Input() post?: IPost
}
