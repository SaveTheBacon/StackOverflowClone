import {Component, ElementRef, ViewChild} from "@angular/core";
import {LoginService} from "../../../services/login.service";
import {IUser} from "../../../models/user.model";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})



export class LoginComponent{
  users? : IUser[]

  @ViewChild("email") email! : ElementRef
  @ViewChild("password") password! : ElementRef
  constructor(private loginService : LoginService) {

  }

  login(){
    this.loginService.login(this.email.nativeElement.value, this.password.nativeElement.value)
  }
}
