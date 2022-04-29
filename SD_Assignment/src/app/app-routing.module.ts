import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./content/pages/home/home.component";
import {NavbarComponent} from "./content/navbar.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'navbar', component: NavbarComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
