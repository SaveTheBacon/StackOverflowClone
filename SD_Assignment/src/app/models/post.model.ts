import {IUser} from "./user.model";
import {ITag} from "./tag.model";


export interface IPost{
  postid? : number
  title: string
  content: string
  score: number
  creation_date: Date
  author: IUser
  tags: ITag[]

}
