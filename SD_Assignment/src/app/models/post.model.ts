import {IUser} from "./user.model";
import {ITag} from "./tag.model";
import {IAnswer} from "./answer.model";
import {IUpvote} from "./upvote.model";
import {IDownvote} from "./downvote.model";


export interface IPost{
  postid? : number
  title: string
  content: string
  score: number
  creationDate: Date
  author: IUser
  tags: ITag[]
  upvotes: IUpvote[]
  downvotes: IDownvote[]
  answers: IAnswer[]

}
