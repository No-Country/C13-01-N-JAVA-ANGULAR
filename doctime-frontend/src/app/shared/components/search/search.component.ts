import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
})
export class SearchComponent {
  @Input() public placeholder = '';
  @Output() public valueChange = new EventEmitter<string>();

  emitValue(value: string) {
    this.valueChange.emit(value);
  }
}
