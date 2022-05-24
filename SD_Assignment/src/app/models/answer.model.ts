import {IUser} from "./user.model";
import {IPost} from "./post.model";
import {IUpvote} from "./upvote.model";
import {IDownvote} from "./downvote.model";


export interface IAnswer{
  answerID?: number
  score: number
  content: string
  user: IUser
  date: Date
  post: IPost

  upvotes: IUpvote
  downvote: IDownvote

}
