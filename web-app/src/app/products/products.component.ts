import { Component } from '@angular/core';
import {Product} from "../model/Product";
import {ProductService} from "../services/product.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {

  products:Product[] = [];
  currentIndex = -1;
  title = '';


  page = 1;
  count = 0;
  pageSize = 3;
  pageSizes = [3, 6, 9];

  constructor(private productService:ProductService) {
  }

  ngOnInit():void {
    this.productService.getProducts().subscribe({
      next : (data)=>{
        const { _embedded, totalElements } = data;
        this.products = _embedded.products;
        this.count = totalElements;
        // console.log(products);
      },
      error : (err)=>{

      }
    })
  }
}
