import { Component, OnInit } from '@angular/core';
import { Membre } from '../membre';
import { ProxyService } from '../proxy.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  membre:Membre = new Membre();
  message="";

  constructor(
    private router: Router,
    private proxyService: ProxyService) { }

  ngOnInit() {
  }
  onEnter(): void {
    this.proxyService.authenticate(this.membre,function() {
    	this.message = "Try again";
    }).then(membre => this.showDocuments(membre));
  }
onRegister(): void {
    this.proxyService.authenticate(this.membre,function() {
    	this.message = "Try again";
    }).then(membre => this.showDocuments(membre));
  }


 showDocuments(membre): void {
    this.membre = membre;
 	this.router.navigate(['documents']);
 }
}



