import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { RouterModule } from '@angular/router';
import { TabsComponent } from './components/tabs/tabs.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [HeaderComponent, FooterComponent, TabsComponent],
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  exports: [HeaderComponent, FooterComponent, TabsComponent],
})
export class SharedModule {}
