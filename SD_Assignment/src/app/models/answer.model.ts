import {IUser} from "./user.model";
import {IPost} from "./post.model";


export interface IAnswer{
  answerid: number
  title: string
  cotent: string
  score: number
  date: Date
  Post: IPost
  poster: IUser

}
