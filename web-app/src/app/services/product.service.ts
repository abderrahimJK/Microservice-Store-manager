import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, retry} from "rxjs";
import {Product} from "../model/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  getProducts():Observable<any>{
    return this.http
      .get<any>(`http://localhost:9999/inventory-service/products`)
      .pipe(retry(1))
  }
}
