import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./content/pages/home/home.component";
import {LoginComponent} from "./content/pages/login/login.component";
import {RegisterComponent} from "./content/pages/register/register.component";
import {CreatePostComponent} from "./content/pages/createPost/createPost.component";
import {SeePostComponent} from "./content/pages/seePost/allPosts/seePost.component";
import {SeeTagComponent} from "./content/pages/seeTag/seeTag.component";
import {SeeUsersComponent} from "./content/pages/seeUsers/seeUsers.component";
import {LogoutComponent} from "./content/pages/logout/logout.component";
import {DetailedPostComponent} from "./content/pages/seePost/detailedPost/detailedPost.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'createPost', component: CreatePostComponent},
  {path: 'seePost', component: SeePostComponent},
  {path: 'seeTag', component: SeeTagComponent},
  {path: 'seeUser', component: SeeUsersComponent},
  {path: 'seePost/:id', component: DetailedPostComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
