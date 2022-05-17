import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../models/user.model";


@Injectable()
export class LoginService{

  getAllUrl = 'http://localhost:8081/users/getAllUsers'
  users? : IUser[]

  constructor(private http: HttpClient) {
  }


  login(email : string, pass : string){
    this.http.get<IUser[]>(this.getAllUrl).subscribe
    ( data =>
    {this.users = data,
      this.checkUsers(this.users, email, pass)}
    )


  }

  checkUsers(users: IUser[], email: string, pass: string){

    let auxUser = users.find(user => user.email == email && user.password == pass)

    if (auxUser){
      console.log("Success!")
      localStorage["email"] = auxUser.email
      localStorage["pass"] = auxUser.password
      localStorage["moderator"] = auxUser.moderator
      localStorage["banned"] = auxUser.banned

    }
    else{
      console.log("Fail!")
    }
  }

}
