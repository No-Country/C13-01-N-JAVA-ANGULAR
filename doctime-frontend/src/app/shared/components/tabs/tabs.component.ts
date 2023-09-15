import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss'],
})
export class TabsComponent {
  @Input() tabs: string[] = [];
  @Output() selectedTabsChange = new EventEmitter<number>();

  activeTabs = 0;

  onTabClick(index: number) {
    this.activeTabs = index;
    this.selectedTabsChange.emit(this.activeTabs);
  }

  handleTabKeydown(event: KeyboardEvent, index: number) {
    if (event.key === 'ArrowLeft' && index > 0) {
      this.onTabClick(index - 1);
      console.log(event, index);
    } else if (event.key === 'ArrowRight' && index < this.tabs.length - 1) {
      this.onTabClick(index + 1);
    }
  }
}
