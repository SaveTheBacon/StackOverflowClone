import {Component, ElementRef, ViewChild} from "@angular/core";
import {RegisterService} from "../../../services/register.service";
import {IUser} from "../../../models/user.model";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})

export class RegisterComponent{


  @ViewChild("email") email! : ElementRef
  @ViewChild("password") password! : ElementRef
  constructor(private registerService: RegisterService) {

  }


  registerUser(){
    let user : IUser = {email : this.email.nativeElement.value, password : this.email.nativeElement.value, score: 0, banned: false, moderator: false}
    this.registerService.createUser(user).subscribe(result => {
      console.log(result)
    })
  }


}
