import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeComponent} from "./content/pages/home/home.component";
import {TabMenuModule} from "primeng/tabmenu";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from 'primeng/inputtext';
import {LoginComponent} from "./content/pages/login/login.component";
import {RegisterComponent} from "./content/pages/register/register.component";
import {CreatePostComponent} from "./content/pages/createPost/createPost.component";
import {SeePostComponent} from "./content/pages/seePost/allPosts/seePost.component";
import {SeeTagComponent} from "./content/pages/seeTag/seeTag.component";
import {NavbarComponent} from "./content/pages/navbar/navbar.component";
import {SeePostService} from "./services/seePost.service";
import {IndividualPostComponent} from "./content/pages/seePost/individualPost/individualPost.component";
import {CommonModule} from "@angular/common";
import {SeeTagService} from "./services/seeTag.service";
import {RegisterService} from "./services/register.service";
import {SeeUsersService} from "./services/seeUsers.service";
import {SeeUsersComponent} from "./content/pages/seeUsers/seeUsers.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    CreatePostComponent,
    SeePostComponent,
    SeeTagComponent,
    NavbarComponent,
    IndividualPostComponent,
    SeeUsersComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    TabMenuModule,
    InputTextModule,
    HttpClientModule,
    CommonModule

  ],
  providers: [
    SeePostService,
    SeeTagService,
    RegisterService,
    SeeUsersService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
