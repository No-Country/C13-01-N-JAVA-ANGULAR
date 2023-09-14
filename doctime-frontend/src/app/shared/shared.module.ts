import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { RouterModule } from '@angular/router';
import { TabsComponent } from './components/tabs/tabs.component';

@NgModule({
  declarations: [HeaderComponent, FooterComponent, TabsComponent],
  imports: [CommonModule, RouterModule],
  exports: [HeaderComponent, FooterComponent, TabsComponent],
})
export class SharedModule {}
