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
    this.refreshPosts()
    const filterParam : number = this.filterParam.nativeElement.value

    let aux: IPost[] = []
    //@ts-ignore
    for(let i = 0; i < this.posts?.length; i++){
      //@ts-ignore
      for(let j = 0; j < this.posts[i].tags.length; j++){
        //@ts-ignore
        if (this.posts[i].tags[j].name.startsWith(filterParam)){
          //@ts-ignore
          aux.push(this.posts[i])
          break
        }
      }
    }

    if(aux.length > 0){
      this.showedPosts = aux
    }



  }

  refreshPosts(){
    this.showedPosts = this.posts

  }
}


