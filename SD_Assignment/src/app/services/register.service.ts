import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IPost} from "../models/post.model";
import {IUser} from "../models/user.model";

@Injectable()
export class RegisterService{

  createUserUrl = 'http://localhost:8081/users/saveUser'

  constructor(private http: HttpClient) {
  }

  createUser(user: IUser){
    console.log(user)
    return this.http.post(this.createUserUrl, user)
  }


}
