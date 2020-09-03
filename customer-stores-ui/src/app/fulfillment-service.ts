import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Receipt} from './receipt';

@Injectable({
  providedIn: 'root'
})
export class FulfillmentService {
  private fulfillmentUrl: string;

  constructor(private http: HttpClient) {
    this.fulfillmentUrl = 'http://localhost:8765/fulfillment-service/fulfillmentapi/products';
  }

  public getReceipt(id: number): Observable<Receipt> {
    return this.http.get<Receipt>(this.fulfillmentUrl + '/' + id);
  }
}
