import { Component, OnInit } from '@angular/core';
import {Receipt} from '../receipt';
import {FulfillmentService} from '../fulfillment-service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-receipt',
  templateUrl: './receipt.component.html',
  styleUrls: ['./receipt.component.css']
})
export class ReceiptComponent implements OnInit {

  receipt: Receipt;

  constructor(private route: ActivatedRoute, private fulfillmentService: FulfillmentService) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.fulfillmentService.getReceipt(id).subscribe(data => {
      this.receipt = data;
    });
  }

}
