import {IAnswer} from "./answer.model";
import {IPost} from "./post.model";
import {IUser} from "./user.model";


export interface IUpvote{
  answer?: IAnswer
  post?: IPost
  author?: IUser
}
