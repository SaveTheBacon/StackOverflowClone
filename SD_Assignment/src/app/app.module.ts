import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeComponent} from "./content/pages/home/home.component";
import {TabMenuModule} from "primeng/tabmenu";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from 'primeng/inputtext';
import {LoginComponent} from "./content/pages/login/login.component";
import {RegisterComponent} from "./content/pages/register/register.component";
import {AskQuestionComponent} from "./content/pages/askQuestion/askQuestion.component";
import {SeeQuestionComponent} from "./content/pages/seeQuestion/seeQuestion.component";
import {SeeTagComponent} from "./content/pages/seeTag/seeTag.component";
import {NavbarComponent} from "./content/pages/navbar/navbar.component";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AskQuestionComponent,
    SeeQuestionComponent,
    SeeTagComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    TabMenuModule,
    InputTextModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
