import{Component} from "@angular/core";
import {TabMenuModule} from 'primeng/tabmenu';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent{


  items: MenuItem[] = [];

  ngOnInit() {
    this.items = [
      {label: 'About', icon: 'pi pi-fw pi-home'},
      {label: 'Products', icon: 'pi pi-fw pi-calendar'},
      {label: 'For teams', icon: 'pi pi-fw pi-pencil'},
    ];
  }
}

