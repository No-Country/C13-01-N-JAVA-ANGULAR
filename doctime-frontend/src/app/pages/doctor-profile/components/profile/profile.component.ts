import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss'],
})
export class ProfileComponent {
  tabs: string[] = ['Dirección', 'Especialidades'];
  activeTabsIndex = 0;

  tabsChange(tab: number) {
    this.activeTabsIndex = tab;
  }
}
