import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../models/user.model";
import {compareSegments} from "@angular/compiler-cli/src/ngtsc/sourcemaps/src/segment_marker";

@Injectable()
export class SeeUsersService{

  getAllUrl = 'http://localhost:8081/users/getAllUsers'
  banUserUrl = 'http://localhost:8081/users/updateUser'

  constructor(private http: HttpClient) {
  }

  getUsers(){
    return this.http.get<IUser[]>(this.getAllUrl)
  }

  banUser(user : IUser){
    let newUser :IUser = {
      userID : user.userID,
      email: user.email,
      password: user.password,
      score: user.score,
      banned: true,
      moderator: user.moderator
    }

    console.log(newUser)

    return this.http.put(this.banUserUrl, newUser)
  }

}
