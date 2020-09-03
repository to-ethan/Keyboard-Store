import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import {HomeComponent} from './home/home.component';
import {ReceiptComponent} from './receipt/receipt.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'keyboards', component: ProductListComponent },
  { path: 'purchase/:id', component: ReceiptComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
