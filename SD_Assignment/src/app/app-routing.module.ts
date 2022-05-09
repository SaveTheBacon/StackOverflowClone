import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./content/pages/home/home.component";
import {LoginComponent} from "./content/pages/login/login.component";
import {RegisterComponent} from "./content/pages/register/register.component";
import {AskQuestionComponent} from "./content/pages/askQuestion/askQuestion.component";
import {SeeQuestionComponent} from "./content/pages/seeQuestion/seeQuestion.component";
import {SeeTagComponent} from "./content/pages/seeTag/seeTag.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'askQuestion', component: AskQuestionComponent},
  {path: 'seeQuestion', component: SeeQuestionComponent},
  {path: 'seeTag', component: SeeTagComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
