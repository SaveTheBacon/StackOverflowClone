import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../models/user.model";
import {Router} from "@angular/router";


@Injectable()
export class LoginService{

  getAllUrl = 'http://localhost:8081/users/getAllUsers'
  users? : IUser[]

  constructor(private http: HttpClient, private router : Router) {
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
    console.log(users)

    if (auxUser){
      if(auxUser.banned == false) {
        console.log("Success!")
        localStorage["userID"] = auxUser.userID
        localStorage["email"] = auxUser.email
        localStorage["pass"] = auxUser.password
        localStorage["moderator"] = auxUser.moderator
        localStorage["banned"] = auxUser.banned
        localStorage["score"] = auxUser.score
        this.router.navigate(["home"])
      }
      else{
        console.log("You are banned!")
      }


    }
    else{
      console.log("Fail!")
    }
  }

}
