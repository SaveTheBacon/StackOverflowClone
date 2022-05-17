import {IUser} from "./user.model";


export interface IPost{
  postid? : number
  title: string
  content: string
  score: number
  creation_date: Date
  author: IUser

}
