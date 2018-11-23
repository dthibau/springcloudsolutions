import { Component, Input, OnInit } from '@angular/core';

import { ProxyService } from '../proxy.service';
import { Document } from '../document';
import { Membre } from '../membre';

@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html'
})
export class DocumentsComponent implements OnInit { 
documents: Document[];

constructor(private proxyService: ProxyService) { }

ngOnInit(): void {
    this.proxyService.getDocuments()
      .then(documents => this.documents = documents);
      console.log(this.documents);
  }
}
