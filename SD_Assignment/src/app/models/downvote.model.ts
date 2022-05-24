import {IAnswer} from "./answer.model";
import {IUser} from "./user.model";
import {IPost} from "./post.model";


export interface IDownvote{
  answer?: IAnswer
  post?: IPost
  author?: IUser
}
