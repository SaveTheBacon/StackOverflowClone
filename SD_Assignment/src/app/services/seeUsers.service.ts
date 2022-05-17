import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {IUser} from "../models/user.model";

@Injectable()
export class SeeUsersService{

  getAllUrl = 'http://localhost:8081/users/getAllUsers'

  constructor(private http: HttpClient) {
  }

  getUsers(){
    return this.http.get<IUser[]>(this.getAllUrl)
  }

}
