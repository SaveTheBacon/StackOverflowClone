import {Component, ElementRef, ViewChild} from "@angular/core";
import {SeePostService} from "../../../../services/seePost.service";
import {IPost} from "../../../../models/post.model";


@Component({
  selector: 'app-seeQuestion',
  templateUrl: './seePost.component.html',
})



export class SeePostComponent {
  posts?: IPost[]
  showedPosts?: IPost[]

  @ViewChild("filterParam") filterParam! : ElementRef
  constructor(private seePostService: SeePostService) {
  }

  ngOnInit(){
    this.seePostService.getPosts().subscribe(data =>
    {console.log(data),
      this.posts = data
    this.refreshPosts()})
  }


  filterQuestions(){
    this.refreshPosts()
    this.showedPosts = this.showedPosts?.filter(x => x.title.startsWith(this.filterParam.nativeElement.value))
    console.log(this.filterParam.nativeElement.value)
    console.log(this.showedPosts)
  }

  filterTag(){
    let aux : IPost[] = []
    this.refreshPosts()
    // @ts-ignore
    aux = this.showedPosts?.filter(p => p.tags.includes(this.filterParam.nativeElement.value))

    this.showedPosts = aux

  }

  refreshPosts(){
    this.showedPosts = this.posts

  }
}


