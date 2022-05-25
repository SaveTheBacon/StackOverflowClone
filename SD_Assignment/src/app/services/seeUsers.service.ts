import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {IUser} from "../models/user.model";
import {compareSegments} from "@angular/compiler-cli/src/ngtsc/sourcemaps/src/segment_marker";

@Injectable()
export class SeeUsersService{

  getAllUrl = 'http://localhost:8081/users/getAllUsers'
  banUserUrl = 'http://localhost:8081/users/banUser'

  constructor(private http: HttpClient) {
  }

  getUsers(){
    return this.http.get<IUser[]>(this.getAllUrl)
  }

  banUser(id : number){
    let params = new HttpParams().set('id', id)
    return this.http.post(this.banUserUrl, "", {params: params})
  }

}
