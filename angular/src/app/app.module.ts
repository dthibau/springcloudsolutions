import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DocumentsComponent } from './documents/documents.component';
import { ProxyService } from './proxy.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DocumentsComponent
  ],
  imports: [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot([
    {
      path: 'login',
      component: LoginComponent
    }, {
      path: 'documents',
      component: DocumentsComponent
    }, {
      path: '',
      redirectTo: '/login',
      pathMatch: 'full'
    },
  ])],
  providers: [ProxyService],
  bootstrap: [AppComponent]
})
export class AppModule { }