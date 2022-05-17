import {Component} from "@angular/core";
import {IUser} from "../../../models/user.model";
import {SeeUsersService} from "../../../services/seeUsers.service";


@Component({
  selector: 'app-seeUsers',
  templateUrl: './seeUsers.component.html',
})

export class SeeUsersComponent{
  users?: IUser[]
  constructor(private seeUsersService: SeeUsersService) {
  }

  ngOnInit(){
    this.seeUsersService.getUsers().subscribe(data =>
    {console.log(data),
      this.users = data})
  }
}
